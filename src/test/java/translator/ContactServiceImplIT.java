package translator;

import com.simple.rest.api.Application;
import com.simple.rest.api.model.Contact;
import com.simple.rest.api.model.ContactResponse;
import com.simple.rest.api.servicetranslator.ContactServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest(classes = {Application.class})
@AutoConfigureMockMvc
public class ContactServiceImplIT {

    @Autowired
    private ContactServiceImpl contactServiceImpl;

    @Test
    public void calculate() {
        ContactResponse result = contactServiceImpl.getContactList();
        Assertions.assertNotNull(result);
    }
}
