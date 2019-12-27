#### `League of OOP`
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
GitHub, pe un repository privat. Fiind nou in utilizarea Git, nu stiam de 
conceptul de tree, credeam ca se da push doar pe master, am aflat prea tarziu
ca ar trebui mai multe branch-uri. O sa tin cont de acest aspect pe viitor.
Totodata, gasisem pe net ca la commit se pune titlu si descriere, asa ca am
crezut ca trebuie sa numerotez commiturile si sa scriu in descriere ce se 
intampla, deci la fiecare dintre primele commituri veti gasi un titlu amiguu
dar care este insotit de o descriere. 