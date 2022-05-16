package it.personalproject.batchdocumentipersonali.compressandprotectdoc.pdfutils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import java.io.File;
import java.io.IOException;

public class PdfProtectionUtils
{
    public static void protectAndSavePdf(File fileToWork,String password) throws IOException
    {

        System.out.println("Sto proteggendo il file "+fileToWork.getName());

        PDDocument doc = PDDocument.load(fileToWork);

        // Define the length of the encryption key.
        // Possible values are 40, 128 or 256.
        int keyLength = 256;

        AccessPermission ap = new AccessPermission();

        // disable printing,
        ap.setCanPrint(false);
        //disable copying
        ap.setCanExtractContent(false);
        //Disable other things if needed...

        // Owner password (to open the file with all permissions) is "12345"
        // User password (to open the file but with restricted permissions, is empty here)
        StandardProtectionPolicy spp = new StandardProtectionPolicy(password, password, ap);
        spp.setEncryptionKeyLength(keyLength);

        //Apply protection
        doc.protect(spp);

        doc.save("outputFiles/"+fileToWork.getName() + "-encrypted.pdf");
        doc.close();
    }
}
