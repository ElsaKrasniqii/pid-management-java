## Menaxhimi i PID-ve ne Java
Projekti Menaxhimi i PID-ve simuleron një sistem që menaxhon Identifikuesit e Proceseve (PID), të cilët janë identifikues të veçantë të proceseve në një sistem operativ. Në një sistem të vërtetë, çdo proces i krijuar merr një PID të veçantë dhe ky PID lirohet kur procesi përfundon ekzekutimin. Qëllimi ynë është të dizajnojmë një sistem të thjeshtë menaxhimi të PID-ve që imiton funksionalitetet bazë të menaxhuesit të PID-ve në një sistem operativ.

### Objektivi:
Objektivi i projektit Menaxhimi i PID-ve është alokimi dhe lirimi i identifikuesve të proceseve (PID-ve) brenda një rangu të caktuar.

Sistemi siguron që:
1. PID-të janë unikë: Dy procese aktive nuk mund të kenë të njëjtin PID.
2. Alokimi dhe lirimi efikas i PID-ve: Një proces merr një PID unik kur krijohet dhe e liron atë kur përfundon ekzekutimin.
3. Rikthimi i PID-ve: Kur një PID lirohet, ai mund të alokohet përsëri për një proces tjetër.
4. Kufizimi i rangut: Sistemi mbështet PID-të brenda një rangu të caktuar.
