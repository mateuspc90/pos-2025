package inatel.dm112.logistica.service;

//import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

// import org.apache.pdfbox.pdmodel.PDDocument;
// import org.apache.pdfbox.pdmodel.PDPage;
// import org.apache.pdfbox.pdmodel.PDPageContentStream;
// import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Component;

import inatel.dm112.logistica.model.Order;

@Component
public class EmailContentGenerator {

    public String generateDeliveryConfirmationContent(Order order) {
        
        StringBuilder content = new StringBuilder();
        content.append("Prezado(a) Cliente,\n\n");
        content.append("O pedido " + order.getOrderNumber() + " foi entregue com sucesso.\n\n");
        content.append("Detalhes da entrega:\n");
        content.append("Data e hora: " + order.getDeliveryDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
        content.append("CPF do recebedor: " + order.getReceiverCpf() + "\n\n");
        
        return content.toString();
    }
}