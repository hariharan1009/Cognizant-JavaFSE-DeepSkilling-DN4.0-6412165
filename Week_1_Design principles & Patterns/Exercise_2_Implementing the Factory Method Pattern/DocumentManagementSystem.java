interface Document {
    void open();
    void save();
    void close();
}
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document...");
    }
    
    public void save() {
        System.out.println("Saving Word document...");
    }
    
    public void close() {
        System.out.println("Closing Word document...");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }
    
    public void save() {
        System.out.println("Saving PDF document...");
    }
    
    public void close() {
        System.out.println("Closing PDF document...");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document...");
    }
    
    public void save() {
        System.out.println("Saving Excel document...");
    }
    
    public void close() {
        System.out.println("Closing Excel document...");
    }
}
abstract class DocumentFactory {
    public abstract Document createDocument();
}
class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// Test Class
public class DocumentManagementSystem {
    public static void main(String[] args) {

        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        System.out.println("Testing Word Document:");
        wordDoc.open();
        wordDoc.save();
        wordDoc.close();
        
        System.out.println("\nTesting PDF Document:");
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.close();
        
        System.out.println("\nTesting Excel Document:");
        excelDoc.open();
        excelDoc.save();
        excelDoc.close();
    }
}