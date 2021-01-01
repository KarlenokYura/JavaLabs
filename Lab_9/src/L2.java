import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;



public class L2 implements HttpSessionAttributeListener {

    // Public constructor is required by servlet spec
    public L2() {
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
        System.out.println("L2:attributeAdded:AtributeName= "
                +sbe.getName());
        System.out.println("L2:attributeAdded:AtributeValue "
                +sbe.getValue());
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("L2:attributeRemoved:AtributeName= "
                +sbe.getName());
        System.out.println("L2:attributeRemoved:AtributeValue "
                +sbe.getValue());
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        System.out.println("L2:attributeReplaced:AtributeName="
                +sbe.getName());
        System.out.println("L2:attributeReplaced:AtributeOldValue "
                +sbe.getValue());
    }
}

