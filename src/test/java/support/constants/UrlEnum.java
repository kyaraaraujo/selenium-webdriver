package support.constants;

public enum UrlEnum {
    SELENIUM_HOME_PAGE("https://www.selenium.dev"),

    SELENIUM_WEB_FORM_PAGE(SELENIUM_HOME_PAGE.getUrl()+"/selenium/web/web-form.html"),
    SELENIUM_ALERTS_PAGE(SELENIUM_HOME_PAGE.getUrl()+"/selenium/web/alerts.html");


    private final String url;

    UrlEnum(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
