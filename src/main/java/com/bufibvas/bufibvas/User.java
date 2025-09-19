package com.bufibvas.bufibvas;

import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;

@javax.inject.Named(value = "user")
@javax.enterprise.context.SessionScoped
public class User implements Serializable {
    private boolean isLoggedIn;
    private boolean isManager;

    public User() {
        isLoggedIn = false;
        isManager = false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void login() throws IOException {
        if (isLoggedIn) return;
        isLoggedIn = true;
        isManager = true;
        FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
    }

    public void logout() throws IOException {
        if (!isLoggedIn) return;
        isLoggedIn = false;
        isManager = false;
        FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");
    }

    public boolean isManager() {
        return isManager;
    }
}
