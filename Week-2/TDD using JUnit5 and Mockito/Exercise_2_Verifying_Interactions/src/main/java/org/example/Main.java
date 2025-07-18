package org.example;
public class Main {
    private ExternalAPI externalApi;

    public Main(ExternalAPI externalApi) {
        this.externalApi = externalApi;
    }

    public void fetchData() {
        externalApi.getData();
    }
}
