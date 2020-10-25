package com.example.weather;

public class Clima {


    private String ClimaUrl;
    private String forecastDia;
    private String ForecastDescription;
    private String ForecastMinMax;

    public Clima(String climaUrl, String forecastDia, String forecastDescription, String forecastMinMax) {
        ClimaUrl = climaUrl;
        this.forecastDia = forecastDia;
        ForecastDescription = forecastDescription;
        ForecastMinMax = forecastMinMax;
    }

    public String getClimaUrl() {
        return ClimaUrl;
    }

    public void setClimaUrl(String climaUrl) {
        ClimaUrl = climaUrl;
    }

    public String getForecastDia() {
        return forecastDia;
    }

    public void setForecastDia(String forecastDia) {
        this.forecastDia = forecastDia;
    }

    public String getForecastDescription() {
        return ForecastDescription;
    }

    public void setForecastDescription(String forecastDescription) {
        ForecastDescription = forecastDescription;
    }

    public String getForecastMinMax() {
        return ForecastMinMax;
    }

    public void setForecastMinMax(String forecastMinMax) {
        ForecastMinMax = forecastMinMax;
    }
}
