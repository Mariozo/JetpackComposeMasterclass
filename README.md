<!-----



Conversion time: 0.666 seconds.


Using this Markdown file:

1. Paste this output into your source file.
2. See the notes and action items below regarding this conversion run.
3. Check the rendered output (headings, lists, code blocks, tables) for proper
   formatting and use a linkchecker before you publish this page.

Conversion notes:

* Docs to Markdown version 1.0β44
* Wed Feb 26 2025 04:32:20 GMT-0800 (PST)
* Source doc: Jetpack CM - Box LV
----->



# 
        Jetpack CM - Box

[https://otter.ai/u/eLETIddNdcn5ZrGjxjhVe-9YzNQ?view=transcript](https://otter.ai/u/eLETIddNdcn5ZrGjxjhVe-9YzNQ?view=transcript)

Šajā nodaļā galvenā uzmanība tika pievērsta Box komponējamo elementu izmantošanai Android izstrādē, lai centrētu un izlīdzinātu **Composable **vienumus izkārtojumā. Galvenie punkti ietver **Composable **elementu centrēšanu ar vienu līdzinājuma modifikatoru, izmantojot īpašas līdzinājuma vērtības, piemēram, augšējo sākumu vai apakšējo centru, un Box tvērumu priekšrocības unikāliem modifikatoriem. Piemēri ietver teksta un attēlu izlīdzināšanu, **Composable **elementu izveidi ar attēliem un ikonu pogām un gradientu lietošanu dinamiskam saturam. Modifikators matchParentSize tika izcelts, lai saglabātu pareizo izmēru attiecībā pret vecāku izkārtojumu. Sesijā tika uzsvērta Box efektivitāte saliekamo elementu centrēšanai salīdzinājumā ar rindu vai kolonnu izmantošanu.


## 
        **Darbības vienumi**



* [ ] Izpētiet izmēru modifikatoru izmantošanu programmā Jetpack Compose un to, kā tie ietekmē **Composable **uzvedību vecāku / bērnu attiecībās.
* [ ] Lejupielādējiet Kermit attēlu no skaļruņa GitHub krātuves un izmantojiet to piemērā.

## 
        **Kontūra**


### 
        **Composable centrēšana ar kastēm**

* **PL **izskaidro lodziņu primāro izmantošanu, lai centrētu **Composable **izkārtojuma iekšpusē, uzsverot viena līdzinājuma modifikatora izmantošanas vienkāršību.
* Tiek apspriestas lodziņu izlīdzināšanas opcijas, tostarp centrā, augšējā galā un apakšējā centrā, kā arī piemēri, kā šie līdzinājumi ietekmē saliekamos.
* **PL **izceļ problēmu, ka saliekamie elementi tiek zīmēti viens virs otra, kas izskatās neērti, it īpaši tekstiem.
* Tiek ieviests lodziņa tvēruma jēdziens, kas ļauj piekļūt unikāliem modifikatoriem lodziņā, piemēram, Align modifikatoram.

### 
        **Tekstu līdzināšana lodziņā**

* **PL **parāda, kā izmantot līdzināšanas modifikatoru, lai novietotu tekstu noteiktās lodziņa apgabalos, piemēram, augšpusē un apakšējā centrā.
* Piemērs par teksta "Hello World" līdzināšanu augšpusē sākumā un citu tekstu apakšējā centrā ir sniegts, lai ilustrētu līdzināšanas opcijas.
* Tiek apspriests šīs tehnikas pielietojums, lai izveidotu **Composable **, piemēram, attēlu ar ikonas pogu augšpusē, un vispirms ir jāuzzīmē attēls.
* **PL **piemin Kermit attēla izmantošanu un paskaidro, kā iestatīt attēlu komponējamu ar gleznotāja resursu.

### 
        **Ikonu pogu pārklājums uz attēliem**

* Tiek paskaidrots, kā attēla augšpusē novietot ikonas pogu, nodrošinot, ka ikonas poga ir novilkta zem attēla.
* Ir aprakstīts process, kā izveidot ikonu pogu ar attēla vektoru un iestatīt tās satura aprakstu uz nulli.
* Tiek uzsvērts, cik svarīgi ir iestatīt ikonas pogas nokrāsu baltā krāsā, lai nodrošinātu labāku redzamību tumšā attēlā.
* **PL **apspriež nepieciešamību līdzināt ikonas pogu lodziņa apakšējā galā, izmantojot rekvizītu modifikators.align.

### 
        **Dinamiskie gradienti ikonu pogām**

* **PL **iesaka izmantot tumšu gradientu, lai nodrošinātu baltās ikonas pogas redzamību dinamiskos attēlos.
* Ir izskaidrots komponējamā gradienta noteikšanas process un tā pielietošana kastē, kurā atrodas attēls.
* Tiek demonstrēta vertikālā gradienta izmantošana, pārejot no caurspīdīga uz melnu, un gradients nav redzams, jo kastītei nav skaidra izmēra.
* Tiek apspriesta fillMaxSize modifikatora ietekme uz kastes izmēru un nepieciešamība pēc fiksēta izmēra, lai gradients būtu redzams.

### 
        **Vecāku izmēra saskaņošana ar kastēm**


    **PL **izskaidro fillMaxSize modifikatora darbību un tā ietekmi uz kastes izmēru.

* Tiek apspriesta modifikatora matchParentSize ieviešana, kas ir pieejams tikai kastes ietvaros.
* Tiek demonstrēta modifikatora matchParentSize izmantošana, lai nodrošinātu, ka lodziņš aizpilda lielākās tajā esošās **Composable **, šajā gadījumā attēla, izmēru.
* Gala rezultāts parāda, ka gradients aizpilda pareizo izmēru, un ikonas poga ir labāk redzama, kā arī ieteikumi krāsu pielāgošanai.

### 
        **Kastīšu kopsavilkums un papildu lietojumi**

* **PL **atkārto lodziņu primāro izmantošanu, lai centrētu **Composable **izkārtojumā, un tam ir nepieciešams tikai viens izlīdzināšanas modifikators.
* Tiek salīdzināts lodziņa un rindas vai kolonnas izmantošana centrēšanai, kas ir vienkāršāka.
* Tiek minēts, cik svarīgi ir izprast lieluma modifikatorus un to uzvedību, solot šo tēmu sīkāk aplūkot vēlāk kursa laikā.
* Sesija noslēdzas ar atgādinājumu par lodziņu lietderību dažādiem komponējamiem līdzinājumiem un centrēšanas vajadzībām.
