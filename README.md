Jetpack CM - Box

[https://otter.ai/u/eLETIddNdcn5ZrGjxjhVe-9YzNQ?view=transcript](https://www.google.com/url?q=https://otter.ai/u/eLETIddNdcn5ZrGjxjhVe-9YzNQ?view%3Dtranscript\&sa=D\&source=editors\&ust=1740575976410450\&usg=AOvVaw0z0oPWl94QMvwNvix5nQL1)

Diskusijā galvenā uzmanība tika pievērsta Box komponējamo elementu izmantošanai Android izstrādē, lai centrētu un izlīdzinātu **Composable** vienumus izkārtojumā. Galvenie punkti ietver **Composable** elementu centrēšanu ar vienu līdzinājuma modifikatoru, izmantojot īpašas līdzinājuma vērtības, piemēram, augšējo sākumu vai apakšējo centru, un Box tvērumu priekšrocības unikāliem modifikatoriem. Piemēri ietver teksta un attēlu izlīdzināšanu, **Composable** elementu izveidi ar attēliem un ikonu pogām un gradientu lietošanu dinamiskam saturam. Modifikators matchParentSize tika izcelts, lai saglabātu pareizo izmēru attiecībā pret vecāku izkārtojumu. Sesijā tika uzsvērta Box efektivitāte saliekamo elementu centrēšanai salīdzinājumā ar rindu vai kolonnu izmantošanu.


## **Darbības vienumi**

- \[ ] Izpētiet izmēru modifikatoru izmantošanu programmā Jetpack Compose un to, kā tie ietekmē **Composable** uzvedību vecāku / bērnu attiecībās.
- \[ ] Lejupielādējiet Kermit attēlu no skaļruņa GitHub krātuves un izmantojiet to piemērā.


## **Kontūra**

### **Composable centrēšana ar kastēm**

- **PL** izskaidro lodziņu primāro izmantošanu, lai centrētu **Composable** izkārtojuma iekšpusē, uzsverot viena līdzinājuma modifikatora izmantošanas vienkāršību.
- Tiek apspriestas lodziņu izlīdzināšanas opcijas, tostarp centrā, augšējā galā un apakšējā centrā, kā arī piemēri, kā šie līdzinājumi ietekmē saliekamos.
- **PL** izceļ problēmu, ka saliekamie elementi tiek zīmēti viens virs otra, kas izskatās neērti, it īpaši tekstiem.
- Tiek ieviests lodziņa tvēruma jēdziens, kas ļauj piekļūt unikāliem modifikatoriem lodziņā, piemēram, Align modifikatoram.
