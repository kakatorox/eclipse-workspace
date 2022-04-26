package cl.desafiolatam.trazap.app.messagemanagerimpl;

import java.util.Locale;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import cl.desafiolata.trazap.app.messagemanager.MessageManager;

@Component("messageManager")
public class MessageManagerImpl implements MessageManager{

	@Autowired
	private MessageSource messageSource;

	@Override
	public String getResourceMessageKey(String key) {
		// TODO Auto-generated method stub
		ResourceBundle resourceBundle = ResourceBundle.getBundle(key);
		return messageSource.getMessage(key, null,new Locale("CL"));
	}
}
