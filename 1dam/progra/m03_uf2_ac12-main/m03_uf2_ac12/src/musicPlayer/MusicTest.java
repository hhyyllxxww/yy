package musicPlayer;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

// Hatful of Hollow
// 1 Heaven Knows I'm Miserable Now
// 2 Handsome Devil
// 3 Please Please Please Let Me Get What I Want
// 4 William, It Was Really Nothing
// 5 How Soon Is Now?
// 6 This Night Has Opened My Eyes
// 7 Back to the Old House
// 8 This Charming Man

// Norman Fucking Rockwell!
// 1 Norman fucking Rockwell
// 2 Doin' Time
// 3 The greatest
// 4 Mariners Apartment Complex
// 5 Fuck it I love you
// 6 Happiness is a butterfly
// 7 Venice Bitch
// 8 Love song

// La La Land - The Complete Musical Experience
// 1 Another Day of Sun
// 2 Someone In the Crowd
// 3 A Lovely Night
// 4 Mia & Sebastian's Theme (Late For the Date)
// 5 Planetarium
// 6 It's Over / Engagement Party
// 7 Epilogue
// 8 The End

public class MusicTest {
		
		public static Scanner sc = new Scanner(System.in).useLocale(Locale.UK);
		public static void main(String[] args) {

			
			System.out.println(
					  "**********************************************************************\n"
					+ "* MUSIC PLAYER                              © Gina Cruselles Juidias *\n"
					+ "*                                                                    *\n"
					+ "* Program to reproduce wav files                                     *\n"
					+ "**********************************************************************\n");
			
			MusicLibrary musicLibrary = loadMusicLibraryMP3();
			
			CD cdSelectedCd = menuCD(musicLibrary);
			if (cdSelectedCd == null) System.out.println("Bye bye!");
			System.out.println();
			
			while(cdSelectedCd != null) {
				
				Song song = menuSelectSong(cdSelectedCd);
				System.out.println();
				if (song == null) cdSelectedCd = menuCD(musicLibrary);
				if (cdSelectedCd == null) System.out.println("Bye bye!");
				System.out.println();
				
				while(song != null){
					
					System.out.println("1.PLAY     2.STOP     3.PAUSE     4.RESUME     5.SHOW LYRICS     0.PLAY ANOTHER SONG");
					byte option = dataEntryByteMinMax("Choose menu option: ", (byte)0, (byte)5);
					
					switch(option){
					case 0:
						song.getSound().stop();
						song = null;
						System.out.println();
						break;
					
					case 1:
						if(song.getSound().getStatus() == Status.PLAYING){
							System.out.println("Song already playing!\n");
						}else{
							song.getSound().play();
							System.out.println();
						}
						break;
						
					case 2:
						if(song.getSound().getStatus() == Status.STOPPED){
							System.out.println("Song is not playing!\n");
						}else{
							song.getSound().stop();
							System.out.println();
						}
						
						break;
						
					case 3:
						if(song.getSound().getStatus() == Status.PAUSED){
							System.out.println("The song is not playing!\n");
						}else{
							song.getSound().pause();
							System.out.println();
						}
						
						break;
						
					case 4:
						if(song.getSound().getStatus() == Status.PAUSED){
							song.getSound().resume();
							System.out.println();
						}else{
							System.out.println("Song is not paused!\n");
						}
						
						break;
						
					case 5:
						System.out.println(song.getLyrics()+"\n");
						break;
					}
				}		
			}		
		}

		
		/**
		 * @return
		 */
		private static MusicLibrary loadMusicLibraryMP3() {
			//Sounds //Create sounds per songs needed
			String path = "songs"+File.separator+"mp3"+File.separator;
			Sound sound1_1 = new Sound(path+"1_1.mp3");
			Sound sound1_2 = new Sound(path+"1_2.mp3");
			Sound sound1_3 = new Sound(path+"1_3.mp3");
			Sound sound1_4 = new Sound(path+"1_4.mp3");
			Sound sound1_5 = new Sound(path+"1_5.mp3");
			Sound sound1_6 = new Sound(path+"1_6.mp3");
			Sound sound1_7 = new Sound(path+"1_7.mp3");
			Sound sound1_8 = new Sound(path+"1_8.mp3");

			Sound sound2_1 = new Sound(path+"2_1.mp3");
			Sound sound2_2 = new Sound(path+"2_2.mp3");
			Sound sound2_3 = new Sound(path+"2_3.mp3");
			Sound sound2_4 = new Sound(path+"2_4.mp3");
			Sound sound2_5 = new Sound(path+"2_5.mp3");
			Sound sound2_6 = new Sound(path+"2_6.mp3");
			Sound sound2_7 = new Sound(path+"2_7.mp3");
			Sound sound2_8 = new Sound(path+"2_8.mp3");
			
			Sound sound3_1 = new Sound(path+"3_1.mp3");
			Sound sound3_2 = new Sound(path+"3_2.mp3");
			Sound sound3_3 = new Sound(path+"3_3.mp3");
			Sound sound3_4 = new Sound(path+"3_4.mp3");
			Sound sound3_5 = new Sound(path+"3_5.mp3");
			Sound sound3_6 = new Sound(path+"3_6.mp3");
			Sound sound3_7 = new Sound(path+"3_7.mp3");
			Sound sound3_8 = new Sound(path+"3_8.mp3");
			
			//Artist  //Create the artists of the songs
			Artist thesmiths = new Artist("The Smiths", "img", "The Smiths were an English rock band formed in Manchester in 1982, composed of singer Morrissey, guitarist Johnny Marr, bassist Andy Rourke, and drummer Mike Joyce.");
			Artist lana = new Artist("Lana del Rey", "img", "Elizabeth Woolridge Grant (born June 21, 1985), known professionally as Lana Del Rey, is an American singer-songwriter. Her music is noted for its cinematic quality and exploration of tragic romance, glamour, and melancholia, with frequent references to contemporary pop culture and 1950s–70s Americana.");
			Artist hurwitz = new Artist("Justin Hurwitz", "img", "Justin Hurwitz (born January 22, 1985) is an American film composer and a television writer. He is best known for his longtime collaboration with director Damien Chazelle, scoring each of his films: Guy and Madeline on a Park Bench (2009), Whiplash (2014), La La Land (2016), First Man (2018), and Babylon (2022).");
			
//			//Songs  //Create songs per sounds created
			Song song1_1 = new Song(1, "Heaven Knows I'm Miserable Now", 3.36f, (short)2, thesmiths, "Morrissey, Johnny Marr", sound1_1, "The Smiths", "I was happy in the haze of a drunken hour\n"
					+ "But heaven knows I'm miserable now\n"
					+ "I was looking for a job, and then I found a job\n"
					+ "And heaven knows I'm miserable now\n"
					+ "In my life\n"
					+ "Why do I give valuable time\n"
					+ "To people who don't care if I live or die?\n"
					+ "Two lovers entwined pass me by\n"
					+ "And heaven knows I'm miserable now\n"
					+ "I was looking for a job, and then I found a job\n"
					+ "And heaven knows I'm miserable now\n"
					+ "In my life\n"
					+ "Oh, why do I give valuable time\n"
					+ "To people who don't care if I live or die?\n"
					+ "What she asked of me at the end of the day\n"
					+ "Caligula would have blushed\n"
					+ "\"Oh, you've been in the house too long\" she said\n"
					+ "And I naturally fled\n"
					+ "In my life\n"
					+ "Why do I smile\n"
					+ "At people who I'd much rather kick in the eye?\n"
					+ "I was happy in the haze of a drunken hour\n"
					+ "But heaven knows I'm miserable now\n"
					+ "\"Oh, you've been in the house too long\" she said\n"
					+ "And I naturally fled\n"
					+ "In my life\n"
					+ "Oh, why do I give valuable time\n"
					+ "To people who don't care if I live or die?");
				
			Song song1_2 = new Song(2, "Handsome Devil", 2.45f, (short)1984, thesmiths, "Morrissey, Johnny Marr", sound1_2, "The Smiths", "All the streets are crammed with things\n"
					+ "Eager to be held\n"
					+ "I know what hands are for\n"
					+ "And I'd like to help myself\n"
					+ "You ask me the time\n"
					+ "But I sense something more\n"
					+ "And I would like to give\n"
					+ "What I think you're asking for\n"
					+ "You handsome devil\n"
					+ "Oh, you handsome devil\n"
					+ "Let me get my hands\n"
					+ "On your mammary glands\n"
					+ "And let me get your head\n"
					+ "On the conjugal bed\n"
					+ "I say, I say, I say\n"
					+ "I crack the whip\n"
					+ "And you skip\n"
					+ "But you deserve it\n"
					+ "You deserve it, deserve it, deserve it\n"
					+ "A boy in the bush\n"
					+ "Is worth two in the hand\n"
					+ "I think I can help you get through your exams\n"
					+ "Oh, you handsome devil\n"
					+ "Oh, let me get my hands\n"
					+ "On your mammary glands\n"
					+ "And let me get your head\n"
					+ "On the conjugal bed\n"
					+ "I say, I say, I say\n"
					+ "I crack the whip\n"
					+ "And you skip\n"
					+ "But you deserve it\n"
					+ "You deserve it, deserve it, deserve it\n"
					+ "And when we're in your scholarly room\n"
					+ "Who will swallow whom ?\n"
					+ "When we're in your scholarly room\n"
					+ "Who will swallow whom ?\n"
					+ "You handsome devil\n"
					+ "Oh, let me get my hands\n"
					+ "On your mammary glands\n"
					+ "And let me get your head\n"
					+ "On the conjugal bed\n"
					+ "I say, I say, I say\n"
					+ "There's more to life than books, you know\n"
					+ "But not much more\n"
					+ "Oh, there's more to life than books, you know\n"
					+ "But not much more, not much more\n"
					+ "Oh, you handsome devil\n"
					+ "Oh, you handsome devil\n"
					+ "Ow");
			
			Song song1_3 = new Song(3, "Please Please Please Let Me Get What I Want", 1.54f, (short)1984, thesmiths, "Morrissey, Johnny Marr", sound1_3, "The Smiths", "Good times for a change\n"
					+ "See, the luck I've had\n"
					+ "Can make a good man\n"
					+ "Turn bad\n"
					+ "So please, please, please\n"
					+ "Let me, let me, let me\n"
					+ "Let me get what I want\n"
					+ "This time\n"
					+ "Haven't had a dream in a long time\n"
					+ "See, the life I've had\n"
					+ "Can make a good man bad\n"
					+ "So for once in my life\n"
					+ "Let me get what I want\n"
					+ "Lord knows, it would be the first time\n"
					+ "Lord knows, it would be the first time");
			
			Song song1_4 = new Song(4, "William, It Was Really Nothing", 2.11f, (short)1984, thesmiths, "Morrissey, Johnny Marr", sound1_4, "The Smiths", "The rain falls hard on a humdrum town\n"
					+ "This town has dragged you down\n"
					+ "Oh, the rain falls hard on a humdrum town\n"
					+ "This town has dragged you down\n"
					+ "Oh no, and everybody's got to live their life\n"
					+ "And God knows I've got to live mine\n"
					+ "God knows I've got to live mine\n"
					+ "William, William, it was really nothing\n"
					+ "William, William, it was really nothing\n"
					+ "It was your life\n"
					+ "How can you stay with a fat girl who'll say\n"
					+ "\"Oh, would you like to marry me?\n"
					+ "And if you like, you can buy the ring\"\n"
					+ "She doesn't care about anything\n"
					+ "Would you like to marry me?\n"
					+ "And if you like, you can buy the ring\n"
					+ "I don't dream about anyone except myself\n"
					+ "Oh, William, William, it was really nothing\n"
					+ "William, William,");
			
			Song song1_5 = new Song(5, "How Soon Is Now?", 6.48f, (short)1984, thesmiths, "Morrissey, Johnny Marr", sound1_5, "The Smiths", "I am the son\n"
					+ "And the heir\n"
					+ "Of a shyness that is criminally vulgar\n"
					+ "I am the son and heir\n"
					+ "Of nothing in particular\n"
					+ "You shut your mouth\n"
					+ "How can you say\n"
					+ "I go about things the wrong way?\n"
					+ "I am human and I need to be loved\n"
					+ "Just like everybody else does\n"
					+ "I am the son\n"
					+ "And the heir\n"
					+ "Of a shyness that is criminally vulgar\n"
					+ "I am the son and heir\n"
					+ "Of nothing in particular\n"
					+ "You shut your mouth\n"
					+ "How can you say\n"
					+ "I go about things the wrong way?\n"
					+ "I am human and I need to be loved\n"
					+ "Just like everybody else does\n"
					+ "There's a club if you'd like to go\n"
					+ "You could meet somebody who really loves you\n"
					+ "So you go and you stand on your own\n"
					+ "And you leave on your own\n"
					+ "And you go home and you cry\n"
					+ "And you want to die\n"
					+ "When you say it's gonna happen now\n"
					+ "When exactly do you mean?\n"
					+ "See I've already waited too long\n"
					+ "And all my hope is gone\n"
					+ "You shut your mouth\n"
					+ "How can you say\n"
					+ "I go about things the wrong way?\n"
					+ "I am human and I need to be loved\n"
					+ "Just like everybody else does");
			
			Song song1_6 = new Song(6, "This Night Has Opened My Eyes", 3.44f, (short)1984, thesmiths, "Morrissey, Johnny Marr", sound1_6, "img", "In a river the colour of lead\n"
					+ "Immerse the baby's head\n"
					+ "Wrap her up in the News Of The World\n"
					+ "Dump her on a doorstep, girl\n"
					+ "This night has opened my eyes\n"
					+ "And I will never sleep again\n"
					+ "You kicked and cried like a bullied child\n"
					+ "A grown man of 25\n"
					+ "Oh, he said he'd cure your ills\n"
					+ "But he didn't and he never will\n"
					+ "Oh, save your life\n"
					+ "'Because you've only got one\n"
					+ "The dream has gone\n"
					+ "But the baby is real\n"
					+ "Oh, you did a good thing\n"
					+ "She could have been a poet\n"
					+ "Or, she could have been a fool\n"
					+ "Oh, you did a bad thing\n"
					+ "And I'm not happy\n"
					+ "And I'm not sad\n"
					+ "A shoeless child on a swing\n"
					+ "Reminds you of your own again\n"
					+ "She took away your troubles\n"
					+ "Oh, but then again she left pain\n"
					+ "Oh, please save your life\n"
					+ "Because you've only got one\n"
					+ "The dream has gone\n"
					+ "But the baby is real\n"
					+ "Oh, you did a good thing\n"
					+ "She could have been a poet\n"
					+ "Or, she could have been a fool\n"
					+ "Oh, you did a bad thing\n"
					+ "And I'm not happy\n"
					+ "And I'm not sad\n"
					+ "Oh\n"
					+ "Oh\n"
					+ "And I'm not happy\n"
					+ "And I'm not sad\n"
					+ "Oh\n"
					+ "Oh\n"
					+ "Oh\n"
					+ "And I'm not happy\n"
					+ "And I'm not sad");
			
			Song song1_7 = new Song(7, "Back to the Old House", 3.04f, (short)1984, thesmiths, "Morrissey, Johnny Marr", sound1_7, "The Smiths", "I would rather not go\n"
					+ "Back to the old house\n"
					+ "I would rather not go\n"
					+ "Back to the old house\n"
					+ "There's too many bad memories\n"
					+ "Too many memories there\n"
					+ "When you cycled by\n"
					+ "Here began all my dreams\n"
					+ "The saddest thing I've ever seen\n"
					+ "And you never knew\n"
					+ "How much I really liked you\n"
					+ "Because I never even told you\n"
					+ "Oh, and I meant to\n"
					+ "Are you still there or have you moved away?\n"
					+ "Or have you moved away?\n"
					+ "I would love to go\n"
					+ "Back to the old house\n"
					+ "But I never will\n"
					+ "I never will\n"
					+ "I never will");
			
			Song song1_8 = new Song(8, "This Charming Man", 2.46f, (short)1984, thesmiths, "Morrissey, Johnny Marr", sound1_8, "The Smiths", "Punctured bicycle\n"
					+ "On a hillside desolate\n"
					+ "Will nature make a man of me yet?\n"
					+ "When in this charming car\n"
					+ "This charming man\n"
					+ "Why pamper life's complexity\n"
					+ "When the leather runs smooth\n"
					+ "On the passenger seat?\n"
					+ "I would go out tonight\n"
					+ "But I haven't got a stitch to wear\n"
					+ "This man said, \"It's gruesome\n"
					+ "That someone so handsome should care\"\n"
					+ "Ah, a jumped-up pantry boy\n"
					+ "Who never knew his place\n"
					+ "He said, \"Return the ring\"\n"
					+ "He knows so much about these things\n"
					+ "He knows so much about these things\n"
					+ "I would go out tonight\n"
					+ "But I haven't got a stitch to wear\n"
					+ "This man said, \"It's gruesome\n"
					+ "That someone so handsome should care\"\n"
					+ "Na, na-na, na-na, na-na, this charming man\n"
					+ "Oh, na-na, na-na, na-na, this charming man\n"
					+ "Ah, a jumped-up pantry boy\n"
					+ "Who never knew his place\n"
					+ "He said, \"Return the ring\"\n"
					+ "He knows so much about these things\n"
					+ "He knows so much about these things\n"
					+ "He knows so much about these things");
			
			
			
			Song song2_1 = new Song(1, "Norman fucking Rockwell", 4.09f, (short)2019, lana, "Lana del Rey, Jack Antonoff", sound2_1, "img", "Godamn, man child\n"
					+ "You fucked me so good that I almost said, \"I love you\"\n"
					+ "You're fun and you're wild\n"
					+ "But you don't know the half of the shit that you put me through\n"
					+ "Your poetry's bad and you blame the news\n"
					+ "But I can't change that and I can't change your mood\n"
					+ "Ah-ah, oh\n"
					+ "'Cause you're just a man\n"
					+ "It's just what you do\n"
					+ "Your head in your hands\n"
					+ "As you color me blue\n"
					+ "Yeah, you're just a man\n"
					+ "All through and through\n"
					+ "Your head in your hands\n"
					+ "As you color me blue\n"
					+ "Blue, blue, blue\n"
					+ "Goddamn, man child\n"
					+ "You act like a kid even though you stand six foot two\n"
					+ "Self-loathing poet, resident Laurel Canyon know-it-all\n"
					+ "You talk to the walls when the party gets bored of you\n"
					+ "But I don't get bored, I just see it through\n"
					+ "Why wait for the best when I could have you?\n"
					+ "You\n"
					+ "'Cause you're just a man\n"
					+ "It's just what you do\n"
					+ "Your head in your hands\n"
					+ "As you color me blue\n"
					+ "Yeah, you're just a man\n"
					+ "All through and through\n"
					+ "Your head in your hands\n"
					+ "As you color me blue\n"
					+ "Blue, blue\n"
					+ "You make me blue\n"
					+ "Blue, blue\n"
					+ "Blue, blue, blue, blue");
			
			Song song2_2 = new Song(2, "Doin' Time", 3.23f, (short)2019, lana, "Lana del Rey, Jack Antonoff", sound2_2, "img", "Summertime, and the livin's easy\n"
					+ "Bradley's on the microphone with Ras MG\n"
					+ "All the people in the dance will agree\n"
					+ "That we're well-qualified to represent the L.B.C\n"
					+ "Me, me and Louie, we gonna run to the party\n"
					+ "And dance to the rhythm, it gets harder\n"
					+ "Me and my girl, we got this relationship\n"
					+ "I love her so bad, but she treats me like shit\n"
					+ "On lockdown, like a penitentiary\n"
					+ "She spreads her lovin' all over\n"
					+ "And when she gets home, there's none left for me\n"
					+ "Summertime, and the livin's easy\n"
					+ "Bradley's on the microphone with Ras MG\n"
					+ "All the people in the dance will agree\n"
					+ "That we're well-qualified to represent the L.B.C\n"
					+ "Me, me and Louie, we gonna run to the party\n"
					+ "And dance to the rhythm, it gets harder\n"
					+ "(Harder, yeah, harder, yeah)\n"
					+ "Oh, take this veil from off my eyes\n"
					+ "My burning sun will, some day, rise\n"
					+ "So, what am I gonna be doin' for a while?\n"
					+ "Said, I'm gonna play with myself\n"
					+ "Show them, now, we've come off the shelf\n"
					+ "Summertime, and the livin's easy\n"
					+ "Bradley's on the microphone with Ras MG\n"
					+ "All the people in the dance will agree\n"
					+ "That we're well-qualified to represent the L.B.C\n"
					+ "Me, me and Louie, we gonna run to the party\n"
					+ "And dance to the rhythm, it gets harder\n"
					+ "(Harder, yeah, harder, yeah)\n"
					+ "Evil, I've come to tell you that she's evil, most definitely\n"
					+ "Evil, ornery, scandalous and evil, most definitely\n"
					+ "The tension, it's getting hotter\n"
					+ "I'd like to hold her head underwater\n"
					+ "(Summertime)\n"
					+ "(Ah, ah, ah)\n"
					+ "Summertime, and the livin's easy\n"
					+ "Bradley's on the microphone with Ras MG\n"
					+ "All the people in the dance will agree\n"
					+ "That we're well-qualified to represent the L.B.C\n"
					+ "Me, me and Louie, we gonna run to the party\n"
					+ "And dance to the rhythm, it gets harder");
			
			Song song2_3 = new Song(3, "The greatest", 5.01f, (short)2019, lana, "Lana del Rey, Jack Antonoff", sound2_3, "img", "I miss Long Beach and I miss you babe\n"
					+ "I miss dancing with you the most of all\n"
					+ "I miss the bar where the Beach Boys would go\n"
					+ "Dennis last stop before Kokomo\n"
					+ "Those nights were on fire\n"
					+ "We couldn't get higher\n"
					+ "We didn't know that we had it all\n"
					+ "But nobody warns you before the fall\n"
					+ "And I'm wasted\n"
					+ "Don't leave, I just need a wake-up call\n"
					+ "I'm facing the greatest\n"
					+ "The greatest loss of them all\n"
					+ "The culture is lit and I had a ball\n"
					+ "I guess I'm signing off after all\n"
					+ "I miss New York and I miss the music\n"
					+ "Me and my friends, we miss rock 'n' roll\n"
					+ "I want shit to feel just like it used to\n"
					+ "And baby, I was doing nothing the most of all\n"
					+ "The culture is lit\n"
					+ "And if this is it\n"
					+ "I had a ball\n"
					+ "I guess that I'm burned out after all\n"
					+ "I'm wasted\n"
					+ "Don't leave, I just need a wake-up call\n"
					+ "I'm facing the greatest\n"
					+ "The greatest loss of them all\n"
					+ "The culture is lit and I had a ball\n"
					+ "I guess that I'm burned out after all\n"
					+ "If this is it, I'm signing off\n"
					+ "Miss doing nothing the most of all\n"
					+ "Hawaii just missed a fireball\n"
					+ "L.A. is in flames, it's getting hot\n"
					+ "Kanye West is blond and gone\n"
					+ "\"Life on Mars\" ain't just a song\n"
					+ "Oh, the live stream's almost on\n"
					+ "");
			
			Song song2_4 = new Song(4, "Mariners Apartment Complex", 4.08f, (short)2019, lana, "Lana del Rey, Jack Antonoff", sound2_4, "img", "You took my sadness out of context\n"
					+ "At the Mariners Apartment Complex\n"
					+ "I ain't no candle in the wind\n"
					+ "I'm the board, the lightning, the thunder\n"
					+ "Kind of girl who's gonna make you wonder\n"
					+ "Who you are and who you've been\n"
					+ "And who I've been is with you on these beaches\n"
					+ "Your Venice bitch, your die-hard, your weakness\n"
					+ "Maybe I could save you from your sins\n"
					+ "So, kiss the sky and whisper to Jesus\n"
					+ "My, my, my, you found this, you need this\n"
					+ "Take a deep breath, baby, let me in\n"
					+ "You lose your way, just take my hand\n"
					+ "You're lost at sea, then I'll command your boat to me again\n"
					+ "Don't look too far, right where you are, that's where I am\n"
					+ "I'm your man\n"
					+ "I'm your man\n"
					+ "They mistook my kindness for weakness\n"
					+ "I fucked up, I know that, but Jesus\n"
					+ "Can't a girl just do the best she can?\n"
					+ "Catch a wave and take in the sweetness\n"
					+ "Think about it, the darkness, the deepness\n"
					+ "All the things that make me who I am\n"
					+ "And who I am is a big-time believer\n"
					+ "That people can change, but you don't have to leave her\n"
					+ "When everyone's talking, you can make a stand\n"
					+ "'Cause even in the dark I feel your resistance\n"
					+ "You can see my heart burning in the distance\n"
					+ "Baby, baby, baby, I'm your man, yeah\n"
					+ "You lose your way, just take my hand\n"
					+ "You're lost at sea, then I'll command your boat to me again\n"
					+ "Don't look too far, right where you are, that's where I am\n"
					+ "I'm your man\n"
					+ "I'm your man\n"
					+ "Catch a wave and take in the sweetness\n"
					+ "Take in the sweetness\n"
					+ "You want this, you need this\n"
					+ "Are you ready for it?\n"
					+ "Are you ready for it? Are you ready for it?");
			
			Song song2_5 = new Song(5, "Fuck it I love you", 3.39f, (short)2019, lana, "Lana del Rey, Jack Antonoff", sound2_5, "img", "I like to see everything in neon\n"
					+ "Drink lime green, stay up 'til dawn\n"
					+ "Maybe the way that I'm living is killing me\n"
					+ "I like to light up the stage with a song\n"
					+ "Do shit to keep me turned on\n"
					+ "But one day I woke up like, \"Maybe I'll do it differently\"\n"
					+ "I moved to California, but it's just a state of mind\n"
					+ "It turns out everywhere you go, you take yourself, that's not a lie\n"
					+ "Wish that you would hold me or just say that you were mine\n"
					+ "It's killing me slowly\n"
					+ "Dream a little dream of me\n"
					+ "Make me into something sweet\n"
					+ "Turn the radio on, dancin' to a pop song\n"
					+ "Fuck it, I love you\n"
					+ "Fuck it, I love you\n"
					+ "Fuck it, I love you\n"
					+ "I really do\n"
					+ "I used to shoot up my veins in neon\n"
					+ "And shit's even brighter; you're gone\n"
					+ "So many things I would say to you, I want you\n"
					+ "You moved to California, but it's just a state of mind\n"
					+ "And you know everyone adores you\n"
					+ "You can't feel it and you're tired\n"
					+ "Baby, wish that you would hold me or just say that you were mine\n"
					+ "But it's killing me slowly\n"
					+ "Dream a little dream of me\n"
					+ "Turn this into something sweet\n"
					+ "Turn the radio on, dancin' to a pop song\n"
					+ "Fuck it, I love you\n"
					+ "Fuck it, I love you\n"
					+ "Fuck it, I love you\n"
					+ "I really do\n"
					+ "It turns out California's more than just a state of mind\n"
					+ "I met you on the Boulevard\n"
					+ "Wind through my hair, you blew my mind\n"
					+ "And if I wasn't so fucked up, I think I'd fuck you all the time\n"
					+ "(I really do)\n"
					+ "It's killing me slowly\n"
					+ "Fuck it, I love you\n"
					+ "(I moved to California, but it's just a state of mind)\n"
					+ "Fuck it, I love you\n"
					+ "(It turns out everywhere you go you take yourself, that's not a lie)\n"
					+ "Fuck it, I love you\n"
					+ "(I wish that you would hold me or just say that you were mine)\n"
					+ "I really do\n"
					+ "(It's killing me slowly)\n"
					+ "California dreamin', got my money on my mind\n"
					+ "(Fuck it, I love you)\n"
					+ "Chances in my veins, runnin' out of time\n"
					+ "(Fuck it, I love you)\n"
					+ "California dreamin', got my money on my mind\n"
					+ "(I really do)\n"
					+ "Chances in my veins, runnin' out of time\n"
					+ "(Fuck it, I love you)\n"
					+ "California dreamin', got my money on my mind\n"
					+ "(Fuck it, I love you)\n"
					+ "Chances in my veins, runnin' out of time\n"
					+ "(Fuck it, I love you)\n"
					+ "California dreamin', got my money on my mind\n"
					+ "(I really do)\n"
					+ "Chances in my veins, runnin' out of time");
			
			Song song2_6 = new Song(6, "Happiness is a butterfly", 4.33f, (short)2019, lana, "Lana del Rey, Jack Antonoff", sound2_6, "img", "Do you want me or do you not?\n"
					+ "I heard one thing, now I'm hearing another\n"
					+ "Dropped a pin to my parking spot\n"
					+ "The bar was hot, it's 2 am, it feels like summer\n"
					+ "Happiness is a butterfly\n"
					+ "Try to catch it like every night\n"
					+ "It escapes from my hands into moonlight\n"
					+ "Every day is a lullaby\n"
					+ "I hum it on the phone like every night\n"
					+ "And sing it for my babies on the tour life\n"
					+ "Ah ah\n"
					+ "If he's a serial killer, then what's the worst\n"
					+ "That could happen to a girl who's already hurt?\n"
					+ "I'm already hurt\n"
					+ "If he's as bad as they say, then I guess I'm cursed\n"
					+ "Looking into his eyes, I think he's already hurt\n"
					+ "He's already hurt\n"
					+ "I said, \"Don't be a jerk, don't call me a taxi\"\n"
					+ "Sitting in your sweatshirt, crying in the backseat\n"
					+ "Ooh\n"
					+ "I just wanna dance with you\n"
					+ "Hollywood and Vine, Black Rabbit in the alley\n"
					+ "I just wanna hold you tight down the avenue\n"
					+ "I just wanna dance with you\n"
					+ "I just wanna dance with you\n"
					+ "Baby, I just wanna dance (dance)\n"
					+ "With you (dance)\n"
					+ "Baby, I just wanna dance (dance)\n"
					+ "With you\n"
					+ "Left the canyon, drove to the club\n"
					+ "I was one thing, now I'm being another\n"
					+ "Go down to Sunset in the truck\n"
					+ "I'll pick you up if you're in town on the corner\n"
					+ "Ah ah\n"
					+ "Happiness is a butterfly\n"
					+ "We should catch it while dancing\n"
					+ "I lose myself in the music, baby\n"
					+ "Every day is a lullaby\n"
					+ "Try to catch it like lightning\n"
					+ "I sing it into my music, I'm crazy\n"
					+ "If he's a serial killer, then what's the worst\n"
					+ "That could happen to a girl who's already hurt?\n"
					+ "I'm already hurt\n"
					+ "If he's as bad as they say, then I guess I'm cursed\n"
					+ "Looking into his eyes, I think he's already hurt\n"
					+ "He's already hurt\n"
					+ "I said, \"don't be a jerk, don't call me a taxi\"\n"
					+ "Sitting in your sweatshirt, crying in the backseat\n"
					+ "Ooh\n"
					+ "I just wanna dance with you\n"
					+ "Hollywood and Vine, Black Rabbit in the alley\n"
					+ "I just wanna hold you tight down the avenue\n"
					+ "I just wanna dance with you\n"
					+ "I just wanna dance with you\n"
					+ "Baby, I just wanna dance (dance)\n"
					+ "With you (dance)\n"
					+ "Baby, I just wanna dance (dance)\n"
					+ "With you");
			
			Song song2_7 = new Song(7, "Venice Bitch", 9.38f, (short)2019, lana, "Lana del Rey, Jack Antonoff", sound2_7, "img", "Fear fun, fear love, fresh out of fucks forever\n"
					+ "Tryin' to be stronger for you\n"
					+ "Ice cream, ice queen, I dream in jeans and leather\n"
					+ "Live stream, I'm sweet for you\n"
					+ "Oh God, miss you on my lips\n"
					+ "It's me your little Venice bitch\n"
					+ "On the stoop with the neighborhood kids\n"
					+ "Callin' out, bang bang, kiss kiss\n"
					+ "You're in the yard, I light the fire\n"
					+ "And as the summer fades away\n"
					+ "Nothing gold can stay\n"
					+ "You write, I tour, we make it work\n"
					+ "You're beautiful and I'm insane\n"
					+ "We're American-made\n"
					+ "Give me Hallmark\n"
					+ "One dream, one life, one lover\n"
					+ "Paint me happy in blue\n"
					+ "Norman Rockwell, no hype under our covers\n"
					+ "It's just me and you\n"
					+ "Oh God, miss you on my lips\n"
					+ "It's me your little Venice bitch\n"
					+ "On the stoop with the neighborhood kids\n"
					+ "Callin' out, bang bang, kiss kiss\n"
					+ "You're in the yard, I light the fire\n"
					+ "And as the summer fades away\n"
					+ "Nothing gold can stay\n"
					+ "You write, I tour, we make it work\n"
					+ "You're beautiful and I'm insane\n"
					+ "We're American-made\n"
					+ "Oh (yeah), oh (yeah), oh (yeah)\n"
					+ "Soundin' off, bang bang, kiss kiss\n"
					+ "Oh (yeah), oh (yeah), oh (yeah)\n"
					+ "Soundin' off, bang bang, kiss kiss\n"
					+ "Oh God, want you on my lips\n"
					+ "It's me your little Venice bitch\n"
					+ "On the stoop with the neighborhood kids\n"
					+ "Soundin' out, bang bang, kiss kiss\n"
					+ "Oh, shatter oh, shatter, oh, shatter\n"
					+ "(Soundin' off, bang bang, kiss kiss)\n"
					+ "Yeah (yeah), oh (yeah), oh (yeah)\n"
					+ "(Soundin' off, bang bang, kiss kiss)\n"
					+ "(Yeah)\n"
					+ "You heard my baby's back in town now\n"
					+ "You should come, come over\n"
					+ "We'll be hanging around now\n"
					+ "You should come, come over\n"
					+ "Oh God, I love him on my lips\n"
					+ "It's me your little Venice bitch\n"
					+ "Touch me with your fingertips\n"
					+ "It's me your little Venice bitch\n"
					+ "Back, back in the garden\n"
					+ "We're getting high now because we're older\n"
					+ "Me myself, I like diamonds\n"
					+ "My baby crimson and clover\n"
					+ "Wha-wha-wha-wha-whatever, everything, whatever\n"
					+ "(Wha-wha-wha-wha-whatever, everything, whatever)\n"
					+ "Ah, ah, ah, ah\n"
					+ "Ah yeah, ah yeah\n"
					+ "(La-la-la-la-la-la, losers, beautiful losers)\n"
					+ "(La-la-la-la-la-la, losers, beautiful losers)\n"
					+ "La-la-la-la-la-la, losers, (yeah) beautiful losers (yeah)\n"
					+ "La-la-la-la-la-la, losers, (yeah) beautiful losers (yeah)\n"
					+ "La-la-la-la-la-la, losers, beautiful losers\n"
					+ "Back in the garden\n"
					+ "We're getting high now because we're older\n"
					+ "Me myself, I like diamonds\n"
					+ "My baby crimson and clover\n"
					+ "Crimson and clover, honey\n"
					+ "Crimson and clover, honey\n"
					+ "Crimson and clover, honey\n"
					+ "Crimson and clover, honey\n"
					+ "Crimson and clover, honey\n"
					+ "Crimson and clover, honey\n"
					+ "Over and over, honey\n"
					+ "Over and over, honey\n"
					+ "Over and over, honey\n"
					+ "Over and over, honey\n"
					+ "Over and over\n"
					+ "If you weren't mine, I'd be jealous of your love\n"
					+ "If you weren't mine, I'd be jealous of your love\n"
					+ "If you weren't mine, I'd be jealous of your love\n"
					+ "If you weren't mine, I'd be jealous of your love\n"
					+ "If you weren't mine, I'd be jealous of your love");
			
			Song song2_8 = new Song(8, "Love song", 3.50f, (short)2019, lana, "Lana del Rey, Jack Antonoff", sound2_8, "img", "In the car, in the car, in the backseat, I'm your baby\n"
					+ "We go fast, we go so fast, we don't move\n"
					+ "I believe in a place you take me\n"
					+ "Make you real proud of your baby\n"
					+ "In your car, I'm a star and I'm burnin' through you\n"
					+ "In your car, I'm a star and I'm burnin' through you\n"
					+ "Oh, be my once in a lifetime\n"
					+ "Lying on your chest, in my party dress\n"
					+ "I'm a fucking mess but I\n"
					+ "Oh, thanks for the high life\n"
					+ "Baby, it's the best, that's a test\n"
					+ "And yes, now I'm here with you and I\n"
					+ "Would like to think that you would stick around\n"
					+ "You know that I'd just die to make you proud\n"
					+ "The taste, the touch, the way we love\n"
					+ "It all comes down to make the sound of our love song\n"
					+ "Dream a dream, here's a scene\n"
					+ "Touch me anywhere 'cause I'm your baby\n"
					+ "Grab my waist, don't waste any part\n"
					+ "I believe that you see me for who I am\n"
					+ "So spill my clothes on the floor of your new car\n"
					+ "Is it safe, is it safe to just be who we are?\n"
					+ "Is it safe, is it safe to just be who we are?\n"
					+ "Oh, be my once in a lifetime\n"
					+ "Lying on your chest, in my party dress\n"
					+ "I'm a fucking mess but I\n"
					+ "Oh, thanks for the high life\n"
					+ "Baby, it's the best, pass the test\n"
					+ "And yes, now I'm here with you and I\n"
					+ "Would like to think that you would stick around\n"
					+ "You know that I'd just die to make you proud\n"
					+ "The taste, the touch, the way we love\n"
					+ "It all comes down to make the sound of our love song\n"
					+ "The taste, the touch, the way we love\n"
					+ "It all comes down to make the sound of our love song");
		
			Song song3_1 = new Song(1, "Another Day of Sun", 3.49f, (short)2016, hurwitz, "Justin Hurwitz", sound3_1, "img", "I think about that day\n"
					+ "I left him at a Greyhound station\n"
					+ "West of Santa Fé\n"
					+ "We were seventeen, but he was sweet and it was true\n"
					+ "Still I did what I had to do\n"
					+ "'Cause I just knew\n"
					+ "Summer Sunday nights\n"
					+ "We'd sink into our seats\n"
					+ "Right as they dimmed out all the lights\n"
					+ "A Technicolor world made out of music and machine\n"
					+ "It called me to be on that screen\n"
					+ "And live inside each scene\n"
					+ "Without a nickel to my name\n"
					+ "Hopped a bus, here I came\n"
					+ "Could be brave or just insane\n"
					+ "We'll have to see\n"
					+ "'Cause maybe in that sleepy town\n"
					+ "He'll sit one day, the lights are down\n"
					+ "He'll see my face and think of how\n"
					+ "He used to know me\n"
					+ "Climb these hills\n"
					+ "I'm reaching for the heights\n"
					+ "And chasing all the lights that shine (lights that shine)\n"
					+ "And when they let you down (it's another day of)\n"
					+ "You'll get up off the ground (it's another day of)\n"
					+ "'Cause morning rolls around\n"
					+ "And it's another day of sun\n"
					+ "I hear 'em every day\n"
					+ "The rhythms in the canyons\n"
					+ "That'll never fade away\n"
					+ "The ballads in the barrooms\n"
					+ "Left by those who came before\n"
					+ "They say \"you gotta want it more\"\n"
					+ "So I bang on every door\n"
					+ "And even when the answer's \"no\"\n"
					+ "Or when my money's running low\n"
					+ "The dusty mic and neon glow\n"
					+ "Are all I need\n"
					+ "And someday as I sing my song\n"
					+ "A small-town kid'll come along\n"
					+ "That'll be the thing to push him on and go, go\n"
					+ "Climb these hills, I'm reaching for the heights\n"
					+ "And chasing all the lights that shine (lights that shine)\n"
					+ "And when they let you down (it's another day of)\n"
					+ "You'll get up off the ground (it's another day of)\n"
					+ "'Cause morning rolls around\n"
					+ "And it's another day of sun\n"
					+ "And when they let you down\n"
					+ "The morning rolls around\n"
					+ "It's another day of sun (oh)\n"
					+ "It's another day of sun (oh)\n"
					+ "It's another day of sun (sun, sun, sun, sun)\n"
					+ "It's just another day of sun (oh)\n"
					+ "Just another day of sun (oh)\n"
					+ "It's another day of sun (sun)\n"
					+ "Another day has just begun (oh)\n"
					+ "It's another day of sun\n"
					+ "It's another day of sun");
			
			Song song3_2 = new Song(2, "Someone In the Crowd", 4.20f, (short)2016, hurwitz, "Justin Hurwitz", sound3_2, "img", "You got the invitation\n"
					+ "You got the right address\n"
					+ "You need some medication?\n"
					+ "The answer's always yes\n"
					+ "A little chance encounter\n"
					+ "Could be the one you've waited for\n"
					+ "Just squeeze a bit more\n"
					+ "Tonight we're on a mission\n"
					+ "Tonight's the casting call\n"
					+ "If this is the real audition\n"
					+ "Oh, God, help us all\n"
					+ "You make the right impression\n"
					+ "Then ev'rybody knows your name\n"
					+ "We're in the fast lane\n"
					+ "Someone in the crowd could be the one you need to know\n"
					+ "The one to finally lift you off the ground\n"
					+ "Someone in the crowd could take you where you wanna go\n"
					+ "If you're the someone ready to be found\n"
					+ "you're the someone ready to be found\n"
					+ "Do what you need to do\n"
					+ "'Til they discover you\n"
					+ "And make you more than who\n"
					+ "You're seeing now\n"
					+ "So with the stars aligned\n"
					+ "I think I'll stay behind\n"
					+ "You've got to go and find\n"
					+ "That someone in the crowd\n"
					+ "That someone in the crowd\n"
					+ "Is someone in the crowd the only thing you really see?\n"
					+ "Watching while the world keeps spinning 'round?\n"
					+ "Somewhere there's a place where I find who I'm gonna be\n"
					+ "A somewhere that's just waiting to be found\n"
					+ "Someone in the crowd could be the one you need to know\n"
					+ "The someone who could lift you off the ground\n"
					+ "Someone in the crowd could take you where you wanna go\n"
					+ "Someone in the crowd could make you\n"
					+ "Someone in the crowd could take you\n"
					+ "Flying off the ground\n"
					+ "If you're the someone ready to be found");
			
			Song song3_3 = new Song(3, "A Lovely Night", 3.56f, (short)2016, hurwitz, "Justin Hurwitz", sound3_3, "img", "The sun is nearly gone\n"
					+ "The lights are turning on\n"
					+ "A silver shine that stretches to the sea\n"
					+ "We've stumbled on a view\n"
					+ "That's tailor-made for two\n"
					+ "What a shame those two are you and me\n"
					+ "Some other girl and guy\n"
					+ "Would love this swirling sky\n"
					+ "But there's only you and I\n"
					+ "And we've got no shot\n"
					+ "This could never be\n"
					+ "You're not the type for me (really?)\n"
					+ "And there's not a spark in sight\n"
					+ "What a waste of a lovely night\n"
					+ "You say there's nothing here?\n"
					+ "Well, let's make something clear\n"
					+ "I think I'll be the one to make that call (but you'll call?)\n"
					+ "And though you looked so cute\n"
					+ "In your polyester suit (it's wool)\n"
					+ "You're right, I'd never fall for you at all\n"
					+ "And maybe this appeals\n"
					+ "To someone not in heels\n"
					+ "Or to any girl who feels\n"
					+ "There's some chance for romance\n"
					+ "But, I'm frankly feeling nothing\n"
					+ "Is that so?\n"
					+ "Or it could be less than nothing\n"
					+ "Good to know, so you agree?\n"
					+ "That's right\n"
					+ "What a waste of a lovely night\n"
					+ "");
			
			Song song3_4 = new Song(4, "Mia & Sebastian's Theme (Late For the Date)", 1.28f, (short)2016, hurwitz, "Justin Hurwitz", sound3_4, "img", "♫");
			Song song3_5 = new Song(5, "Planetarium", 4.18f, (short)2016, hurwitz, "Justin Hurwitz", sound3_5, "img", "♫");
			Song song3_6 = new Song(6, "It's Over / Engagement Party", 1.35f, (short)2016, hurwitz, "Justin Hurwitz", sound3_6, "img", "♫");
			Song song3_7 = new Song(7, "Epilogue", 7.40f, (short)2016, hurwitz, "Justin Hurwitz", sound3_7, "img", "♫");
			Song song3_8 = new Song(8, "The End", 0.47f, (short)2016, hurwitz, "Justin Hurwitz", sound3_8, "img", "♫");
			
//			//Song list
			List<Song> songs1 = new ArrayList<>();
			songs1.add(song1_1);
			songs1.add(song1_2);
			songs1.add(song1_3);
			songs1.add(song1_4);
			songs1.add(song1_5);
			songs1.add(song1_6);
			songs1.add(song1_7);
			songs1.add(song1_8);
			
			List<Song> songs2 = new ArrayList<>();
			songs2.add(song2_1);
			songs2.add(song2_2);
			songs2.add(song2_3);
			songs2.add(song2_4);
			songs2.add(song2_5);
			songs2.add(song2_6);
			songs2.add(song2_7);
			songs2.add(song2_8);
			
			List<Song> songs3 = new ArrayList<>();
			songs3.add(song3_1);
			songs3.add(song3_2);
			songs3.add(song3_3);
			songs3.add(song3_4);
			songs3.add(song3_5);
			songs3.add(song3_6);
			songs3.add(song3_7);
			songs3.add(song3_8);
			
//			//CD  //Create cds you need
			CD cd1 = new CD("Hatful of Hollow", songs1, "img");
			CD cd2 = new CD("Norman Fucking Rockwell!", songs2, "img");
			CD cd3 = new CD("La La Land - The Complete Musical Experience", songs3, "img");
			
//			//CdList
			List<CD> cds = new ArrayList<>();
			cds.add(cd1);
			cds.add(cd2);
			cds.add(cd3);
			
//			//Music library  //Only need one... for now
			MusicLibrary musicLibrary = new MusicLibrary("Music library", cds);
			
			return musicLibrary;
		}

		
		public static Song menuSelectSong(CD cd){
			String text = String.format(
					  "%-5s%-45s%-10s%-10s%-31s\n"
					+ "--------------------------------------------------------------------------------------------\n", "ID", "TITLE", "DURATION", "YEAR", "PRODUCER");
					  
			for (Song song : cd.getSongs()) {
				text += song + "\n";
			}
			System.out.println(text);
			byte option = dataEntryByteMinMax("Choose Song (0 to eject CD): ", (byte)0, (byte)cd.getSongs().size());
			if(option == 0) return null;
			else return cd.getSongs().get(option-1);
		}
		

		public static CD menuCD(MusicLibrary musicLibrary) {
			System.out.println("SELECT CD:");
			
				for (CD cd : musicLibrary.getCds()){
					System.out.println(cd.toString());
				}
				byte option = dataEntryByteMinMax("Choose CD (0 to quit): ", (byte)0, (byte)musicLibrary.getCds().size());
				if(option == 0) return null;
				else return musicLibrary.getCds().get(option-1);
			}
		
		
		public static byte dataEntryByteMinMax(String text, byte min, byte max) {
	        byte number = 0;
	        System.out.print(text);
	        boolean isValid = false;
	        while (!isValid) {
	            if (sc.hasNextByte()) {
	                number = sc.nextByte();
	                if (number >= min && number <= max) {
	                    isValid = true;
	                } else {
	                    System.err.print("Error!\n");
	                    System.out.print(text);
	                }
	            } else {
	                sc.next(); // Consume scanner 
	                System.err.print("Error!\n");
	                System.out.print(text);
	            }
	        }
	        return number;
	    }
		
	}

