package app;

import service.cdService;

public class aplicacao {

    private static cdService cdService = new cdService();

    public static void main(String[] args) {
        port(6789);

        staticFiles.location("/public");

        post("/cd/insert", (request, response) -> cdService.insert(request, response));

        get("/cd/:id", (request, response) -> cdService.get(request, response));

        get("/cd/list/:orderby", (request, response) -> cdoService.getAll(request, response));

        get("/cd/update/:id", (request, response) -> cdService.getToUpdate(request, response));

        post("/cd/update/:id", (request, response) -> cdService.update(request, response));

        get("/cd/delete/:id", (request, response) -> cdService.delete(request, response));

    }
}