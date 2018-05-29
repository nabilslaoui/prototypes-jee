import java.net.ProxySelector;
import java.net.URL;

import javax.xml.ws.WebServiceRef;

import org.wso2.php.EtatServeurAutomates;
import org.wso2.php.xsd.EtatServeurAutomatesRequest;
import org.wso2.php.xsd.EtatServeurAutomatesResponse;

public class Main {

	@WebServiceRef(wsdlLocation = "http://localhost:8080/mockEtatServeurAutomatesBinding?wsdl")
	static EtatServeurAutomates toto = new EtatServeurAutomates();

	public static void main(String[] args) {
		EtatServeurAutomatesRequest parameters = new EtatServeurAutomatesRequest();

		URL url = toto.getWSDLDocumentLocation();

		ProxySelector.setDefault(new MyProxySelector());

		// TODO Auto-generated method stub
		EtatServeurAutomatesResponse resp = toto.getEtatServeurAutomatesPort().etatServeurAutomates(parameters);

		System.out.println(resp);
	}

}
