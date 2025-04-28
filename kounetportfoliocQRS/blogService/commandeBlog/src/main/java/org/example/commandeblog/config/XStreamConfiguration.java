package org.example.commandeblog.config;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.ExplicitTypePermission;
import org.example.polyinformatiquecoreapi.commands.CreateAuthorCommand;

public class XStreamConfiguration {
    public static XStream createXStream() {
        // Crée une instance de XStream
        XStream xstream = new XStream();

        // Interdit toutes les classes par défaut
        xstream.addPermission(NoTypePermission.NONE);

        // Ajoute explicitement la classe CreateAuthorCommand comme autorisée
        xstream.addPermission(new ExplicitTypePermission(new Class[]{CreateAuthorCommand.class}));

        return xstream;
    }
}

