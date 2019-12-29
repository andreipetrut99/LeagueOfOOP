#### `League of OOP` 

---- ETAPA 1 ----
Acest proiect reprezinta o implementare a unui joc MMO minimalist,
intr-un univers 2D, implementat in Java avand ca obiective fundamentarea
practica a constructorilor si agregarii sau mostenirii, familiarizarea cu
Java si conceptele de baza ale POO, obisnuirea cu pincipiile SOLID si cu
scrierea unui cod cat mai generic.

Citirea si scrierea din si in fisier sunt realizate cu ajutorul clasei
GameInputLoader, unde am folosit ca model scheletul din tema precedenta.
Eroii sunt construiti cu ajutorul HeroFactory pe baza informatiilor din
GameInput. 

Clasa Main este folosita pentru instantierea claselor care fac scrierea
si citirea dar si pentru a instantia clasa GameLogic si a incepe jocul.
Logica jocului se desfasoara in clasa GameLogic unde se verifica daca
exista playeri pe aceeasi pozitie pe harta si daca da atunci se ataca si
isi aplica abilitatile unul asupra celuilalt dupa regulile enuntate in 
enuntul proiectului. 

Toti eroii mostenesc clasa Hero care are metode comune tutror celor 4 tipuri
de eroi precum: getteri pentru viata, xp, metode de resetare a nivelului si
a vietii, setarea damageului overtime etc. Clasele cu numele tipului de jucator
contin doar metode specifice acelui tip. Toati modificatorii si constantele se
gasesc in pachetul commons.

In aceasta versiune a temei nu am implementat double-dispatch. 

Pentru o descriere explicita a metodelor si intelegerea lor verificati
javadoc.

Pe parcursul rezolvarii proiectului am salvat codul, in mai multe etape, pe
GitHub, pe un repository privat.

---- ETAPA 2 ---- 
Etapa a doua a acestui proiect vine in completarea jocului cu noi personaje:
ingeri, strategii si un admin.

Am implementat ingerii in pachetul angels, acestia fiind creati cu Factory
Pattern si actionand asupra eroilor prin Visitor Pattern. Clasa Angel 
cuprinde informatiile comune tuturor claselor de ingeri care o mostenesc:
pozitia si metodele abstracte de vizitare. 

Marele Magician sau adminul este implementat ca o instanta singleton care
este anuntata de fiecare data cand se intampla un eveniment important, prin
Observer Pattern. In fiecare metoda care produce un efect interesant pentru 
admin se gaseste o apelare a uneia dintre metodele notify. Scrierea in
fisierul de output se face pe parcurs, dupa fiecare runda.

Strategiile sunt introduse in joc prin folosirea Pattern-ului Strategy astfel:
fiecare erou isi alege contextul in clasa de baza, adica strategia defensiva
sau ofensiva iar apoi aceasta este aplicata prin Visitor Pattern, in functie 
de tipul instantei la runtime. 

Pentru o descriere explicita a metodelor si intelegerea lor verificati
javadoc si codul sursa.

Pe parcursul rezolvarii acestei parti am salvat codul, in mai multe etape, pe
GitHub, pe un repository privat.