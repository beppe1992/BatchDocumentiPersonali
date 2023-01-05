package it.personalproject.batchdocumentipersonali.manipulatedoc;

import it.personalproject.batchdocumentipersonali.common.FiligranaPdfUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

public class ManipulateDocMain
{
        private static final String REMOVE_FILIGRANA_TESTO_SPECIFICO = "REMOVE_FILIGRANA_TESTO_SPECIFICO";


        public static void main(String[] args) throws IOException
        {

            if(args.length == 0){
                System.out.println("PARAMETRO TIPO RUN OBBLIGATORIO");
                System.exit(1);
            }

            String tipoRun = args[0];

            Collection<File> listaFile = recuperaListaFiles();

            if (REMOVE_FILIGRANA_TESTO_SPECIFICO.equals(tipoRun)){
                for (File file : listaFile) {
                    // TODO: sviluppa funzionalità che permetta di configurare la filigrana da rimuovere, al momento non mi serve
                    FiligranaPdfUtils.removeFiligranaAndSavePdf(file, "Produced by the free evaluation copy of TotalHTMLConverter");;
                }
            }
            else{
                System.out.println("PARAMETRO TIPO RUN NON GESTITO");
                System.exit(1);
            }
        }

        private static Collection<File> recuperaListaFiles()
        {
            File directoryInput = new File("inputFiles");
            System.out.println("Cartella da lavorare: " + directoryInput.getAbsolutePath());

            return FileUtils.listFiles(directoryInput, new String[]{ "pdf"}, true);
        }

}
