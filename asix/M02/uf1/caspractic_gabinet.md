# 1. Gabinet d'advocats

`Es vol dissenyar una base de dades relacional per a emmagatzemar informació
sobre els assumptes que porta un gabinet d'advocats.
`

De cada zoo es vol emmagatzemar el seu codi, nom, la ciutat i país on es troba, mida (m2) i pressupost anual.

Cada zoo codifica els seus animals amb un codi propi, de manera que entre zoos es pot donar el cas que es repeteixi.
De cada espècie animal s'emmagatzema un codi d'espècie, el nom vulgar, el nom científic, família a la qual pertany i si es troba en perill d'extinció.

A més, s'ha de guardar informació sobre cada animal que els zoos tenen, com el seu número d'identificació, espècie, sexe, any de naixement, país d'origen i continent.

# 2. Model conceptual
## 2.1. Enllaç públic a l'esquema
[cas 1](aqui_has_d_indicar_la_URL_cas_draw.io)
## 2.2. Esquema conceptual (EC ó ER)
  ![cas 1](indica_el_fitxer_imatge.png)
# 3. Model lògic relacional
## 3.1. Esquema lògic
  Relacio1(<ins>idXX</ins>, atribut1, atribut1, ...)  
  Relacio2(<ins>idZZ</ins>, atribut1, atribut2, ...)
  \...

## 3.2. Diagrama referencial

* El diagrama referencial em serveix per indicar quines claus alienes hi ha a l'esquema lògic  
* La relació referencial és aquella que conté la clau aliena  
* La relació referida és l'origen de la informació. És la part 1, tal com s'ha explicat a classe.

(omple la taula següent amb les claus alienes que hi hagi al cas pràctic)

Relació referencial|Clau aliena|Relació referida
-|:-:|-
x|x|x
x|x|x

# 4. Model físic
## 4.1 Enllaç a l'esquema físic

[script xxx.sql](./path/to/script.sql)

# Plantilla per implementar els casos pràctics

- Per cada cas pràctic s'ha de lliurar un fitxer en format markdown, amb el número d'ordre, guió baix (\_) i el nom del cas.
P.e.: `6_zoos.md`

- L'esquema conceptual (entitat-relació) s'ha de fer amb [draw.io](https://www.draw.io/)). Haureu de generar un enllaç públic i l'esquema exportat a format png.

- El contingut del fitxer ha de seguir la següent estructura numerada de sota. `Esborreu d'aquí (inclòs) cap a dalt quan feu l'entrega`

# 1. Títol

`Aqui hi anirà l'enunciat del cas pràctic`

# 2. Model conceptual
## 2.1. Enllaç públic a l'esquema
[cas xxx](aqui_has_d_indicar_la_URL_cas_draw.io)
## 2.2. Esquema conceptual (EC ó ER)
  ![cas xxx](indica_el_fitxer_imatge.png)
# 3. Model lògic relacional
## 3.1. Esquema lògic
  Relacio1(<ins>idXX</ins>, atribut1, atribut1, ...)  
  Relacio2(<ins>idZZ</ins>, atribut1, atribut2, ...)
  \...

## 3.2. Diagrama referencial

* El diagrama referencial em serveix per indicar quines claus alienes hi ha a l'esquema lògic  
* La relació referencial és aquella que conté la clau aliena  
* La relació referida és l'origen de la informació. És la part 1, tal com s'ha explicat a classe.

(omple la taula següent amb les claus alienes que hi hagi al cas pràctic)

Relació referencial|Clau aliena|Relació referida
-|:-:|-
x|x|x
x|x|x

# 4. Model físic
## 4.1 Enllaç a l'esquema físic

[script xxx.sql](./path/to/script.sql)
