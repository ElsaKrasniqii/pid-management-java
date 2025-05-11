## Menaxhimi i PID-ve ne Java
Projekti Menaxhimi i PID-ve simuleron një sistem që menaxhon Identifikuesit e Proceseve (PID), të cilët janë identifikues të veçantë të proceseve në një sistem operativ. Në një sistem të vërtetë, çdo proces i krijuar merr një PID të veçantë dhe ky PID lirohet kur procesi përfundon ekzekutimin. Qëllimi ynë është të dizajnojmë një sistem të thjeshtë menaxhimi të PID-ve që imiton funksionalitetet bazë të menaxhuesit të PID-ve në një sistem operativ.

### Objektivi:
Objektivi i projektit Menaxhimi i PID-ve është alokimi dhe lirimi i identifikuesve të proceseve (PID-ve) brenda një rangu të caktuar.
Sistemi siguron që:
 -  PID-të janë unikë: Dy procese aktive nuk mund të kenë të njëjtin PID.
 -  Alokimi dhe lirimi efikas i PID-ve: Një proces merr një PID unik kur krijohet dhe e liron atë kur përfundon ekzekutimin.
 -  Rikthimi i PID-ve: Kur një PID lirohet, ai mund të alokohet përsëri për një proces tjetër.
 -  Kufizimi i rangut: Sistemi mbështet PID-të brenda një rangu të caktuar.

### Përshkrimi i Problemit
Sistemet operative kërkojnë një mënyrë efikase për të alokuar dhe liruar PID-të për proceset. Sfida që paraqitet është sigurimi i kushteve të mëposhtme:
- **PID unik**  
  Çdo proces duhet të ketë një identifikues (PID) unik.
- **Rikthimi i PID-ve**  
  Kur një proces përfundon, PID-ja e tij duhet të lirohet dhe të jetë e disponueshme për alokim nga një proces tjetër.
- **Përdorimi efikas i memories**  
  Sistemi duhet të menaxhojë në mënyrë të optimizuar PID-të e alokuara dhe të lira, duke shmangur përdorimin e panevojshëm të burimeve të memories.


### Struktura e të Dhënave:
- Struktura e të dhënave e përdorur për menaxhimin e PID-ve është BitSet, e cila është një mënyrë kompakte për të përfaqësuar një 
numër të madh flamujsh boolean (në këtë rast, disponueshmërinë e PID-ve). Çdo bit në BitSet përputhet me një PID dhe indeksi i bitit 
është pozita relative e PID-së në rang.
- Sistemi përdor konstantet e mëposhtme:
  MIN_PID = 300
  MAX_PID = 5000
- Pra, BitSet do të ndjekë disponueshmërinë e 4701 PID-ve (nga 300 deri në 5000 përfshirë).

### Funksionet Kryesore:

**allocateMap():** Inicializon strukturën e menaxhimit të PID-ve (BitSet) dhe vendos kufirin për PID-të. Kthen 1 nëse është e suksesshme dhe -1 nëse ka dështuar.

**allocatePid():** Alokon një PID të lirë. Nëse nuk ka PID të lirë, kthen -1. Nëse një PID alokohet me sukses, kthen vlerën e PID-së.

**releasePid(int pid):** Liron një PID të alokuar më parë. Nëse PID-ja është brenda kufirit të vlefshëm, vlera përkatëse e BitSet reset-het për të treguar që është e lirë. Nëse PID-ja është jashtë kufirit ose e pavlefshme, ajo hedh një përjashtim.

**isAllocated(int pid):** Kontrollon nëse një PID është aktualisht i alokuar. Kthen true nëse është alokuar, dhe false nëse është i lirë.





















### Përfundim:
Ky projekt është një aplikacion i thjeshtë për kodimin dhe dekodimin e teksteve dhe përmbajtjes nga skedarët duke përdorur algoritmin Base64. Ai ofron një ndërfaqe të thjeshtë dhe mund të përdoret për të kuptuar si funksionon ky algoritëm i kodimit dhe si mund të implementohet në Java.
