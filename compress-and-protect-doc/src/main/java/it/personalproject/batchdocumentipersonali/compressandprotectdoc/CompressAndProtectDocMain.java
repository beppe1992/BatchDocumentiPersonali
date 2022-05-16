package it.personalproject.batchdocumentipersonali.compressandprotectdoc;

import it.personalproject.batchdocumentipersonali.compressandprotectdoc.pdfutils.PdfProtectionUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

public class CompressAndProtectDocMain
{

    private static final String ONLY_COMPRESS = "ONLY_COMPRESS";

    private static final String ONLY_PROTECT = "ONLY_PROTECT";

    private static final String COMPRESS_PROTECT = "COMPRESS_PROTECT";

    public static void main(String[] args) throws IOException
    {

        if(args.length == 0){
            System.out.println("PARAMETRO TIPO RUN OBBLIGATORIO");
            System.exit(1);
        }

        String tipoRun = args[0];

        Collection<File> listaFile = recuperaListaFiles();

        String password = readPassword();


        if(ONLY_COMPRESS.equals(tipoRun)){

        } else if ( ONLY_PROTECT.equals(tipoRun) ){
            for (File file : listaFile) {
                PdfProtectionUtils.protectAndSavePdf(file,password);
            }
        } else if ( COMPRESS_PROTECT.equals(tipoRun) ){

        } else{
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

    private static String readPassword() throws IOException
    {
        for (String line : Files.readAllLines(Paths.get("config/psw.txt"))) {
           return line;
        }

       throw new RuntimeException("FILE DELLA PSW NON TROVATO");
    }
}
