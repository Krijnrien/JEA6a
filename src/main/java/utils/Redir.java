package utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Redir {
    public static void redirect(String relativeUrl) {
        String url = getContextPath() + relativeUrl;

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getContextPath() {
        return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getContextPath();
    }
}
