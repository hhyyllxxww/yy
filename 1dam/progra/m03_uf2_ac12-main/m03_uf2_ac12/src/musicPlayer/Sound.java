package musicPlayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;

public class Sound {

    private String path;
    private Status status;

    private final static int NOTSTARTED = 0;
    private final static int PLAYING = 1;
    private final static int PAUSED = 2;
    private final static int FINISHED = 3;

    public Sound(String path) {
        this.path = path;
        this.status = Status.STOPPED;
        playerStatus = NOTSTARTED;
//        try {
//        	FileInputStream fis = new FileInputStream(path) ;
//			this.player = new Player(fis);
//		} catch (FileNotFoundException | JavaLayerException e) {
//			e.printStackTrace();
//		}
    }

    // the player actually doing all the work
    private Player player;

    // locking object used to communicate with player thread
    private final Object playerLock = new Object();

    // status variable what player thread is doing/supposed to do
    private int playerStatus = NOTSTARTED;

    public Sound(final InputStream inputStream) throws JavaLayerException {
        this.player = new Player(inputStream);
    }


    public Sound(final InputStream inputStream, final AudioDevice audioDevice) throws JavaLayerException {
        this.player = new Player(inputStream, audioDevice);
    }


    /**
     * Starts playback (resumes if paused)
     */
    public void play() {
        synchronized (playerLock) {

            //New JS
            try {
                FileInputStream fis = new FileInputStream(path);
                this.player = new Player(fis);
            } catch (FileNotFoundException | JavaLayerException e) {
                e.printStackTrace();
            }
            //End NEW JS

            switch (playerStatus) {
                case FINISHED:
                case NOTSTARTED:

                    final Runnable r = new Runnable() {
                        public void run() {
                            playInternal();
                        }
                    };
                    final Thread t = new Thread(r);
                    //t.setDaemon(true);
                    t.setPriority(Thread.MAX_PRIORITY);
                    playerStatus = PLAYING;
                    this.status = Status.PLAYING;
                    t.start();
                    break;
                case PAUSED:
                    resume();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Pauses playback. Returns true if new state is PAUSED.
     */
    public boolean pause() {
        synchronized (playerLock) {
            if (playerStatus == PLAYING) {
                playerStatus = PAUSED;
            }
            this.status = Status.PAUSED;
            return playerStatus == PAUSED;
        }
    }

    /**
     * Resumes playback. Returns true if the new state is PLAYING.
     */
    public boolean resume() {
        synchronized (playerLock) {
            if (playerStatus == PAUSED) {
                playerStatus = PLAYING;
                playerLock.notifyAll();
            }
            this.status = Status.PLAYING;
            return playerStatus == PLAYING;
        }
    }

    /**
     * Stops playback. If not playing, does nothing
     */
    public void stop() {
        synchronized (playerLock) {
            this.status = Status.STOPPED;
            playerStatus = FINISHED;
            playerLock.notifyAll();

        }
    }

    private void playInternal() {
        while (playerStatus != FINISHED) {
            try {
                if (!player.play(1)) {
                    break;
                }
            } catch (final JavaLayerException e) {
                break;
            }
            // check if paused or terminated
            synchronized (playerLock) {
                while (playerStatus == PAUSED) {
                    try {
                        playerLock.wait();
                    } catch (final InterruptedException e) {
                        // terminate player
                        break;
                    }
                }
            }
        }
        close();
    }

    /**
     * Closes the player, regardless of current state.
     */
    public void close() {
        synchronized (playerLock) {
            this.status = Status.STOPPED;
            playerStatus = FINISHED;
        }
        try {
            player.close();
        } catch (final Exception e) {
            // ignore, we are terminating anyway
        }
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Object getPlayerLock() {
        return playerLock;
    }

    public int getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(int playerStatus) {
        this.playerStatus = playerStatus;
    }

    // demo how to use
    public static void main(String[] argv) {
        try {
            //  FileInputStream input = new FileInputStream("associations\\musicPlayerJavaZoom2\\church.mp3");
            //Sound player = new Sound("C:\\Users\\joans\\Desktop\\Eclipse202306\\workspace\\m03_uf2_ac06\\src\\musicPlayerJavaZoom2\\Afterlife.mp3");
            //Sound player = new Sound("src\\musicPlayerJavaZoom2\\Afterlife.mp3");
            Sound player = new Sound("songs" + File.separator + "mp3" + File.separator + "rick_astley_never_gonna_give_you_up.mp3");
            // start playing
            player.play();
            System.out.println("Playing");

            // after 5 secs, pause
            Thread.sleep(5000);
            player.pause();
            System.out.println("Pause");

            // after 3 secs, resume
            Thread.sleep(3000);
            System.out.println("Resume");

            player.resume();

            // after 5 secs, stop
            Thread.sleep(5000);
            System.out.println("Stop");

            player.stop();

            // after 3 secs, play again
            Thread.sleep(3000);
            System.out.println("Playing");

            // input = new FileInputStream("associations\\musicPlayerJavaZoom\\church.mp3");
            player = new Sound("associations" + File.separator + "musicPlayerJavaZoom" + File.separator + "church.mp3");
            player.play();

            // after 5 secs, stop again
            Thread.sleep(5000);
            System.out.println("Stop");
            player.stop();

            System.out.println("END");

        } catch (final Exception e) {
            throw new RuntimeException(e);
        }

//		FileInputStream input = new FileInputStream("associations\\musicPlayerJavaZoom\\church.mp3"); 
//      Sound player = new Sound("associations\\musicPlayerJavaZoom\\church.mp3");
//
//      // start playing
//      player.play();
//      System.out.println("Playing");
//
//      // after 5 secs, pause
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        player.pause();     
//        System.out.println("Pause");
//
//        // after 3 secs, resume
//        try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println("Resume");
//
//        player.resume();
//        
//     // after 5 secs, stop
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println("Stop");
//
//        player.stop();
//        
//        // after 3 secs, play again  NOT WORKING
//        try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println("Play");
//
//        new Sound("associations\\musicPlayerJavaZoom\\church.mp3").play();


    }

}
