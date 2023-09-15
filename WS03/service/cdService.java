package service;

import java.util.Scanner;
import java.time.LocalDate;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import dao.cdDAO;
import model.cd;

public class cdService {
    private cdDAO cdDAO = new cdDAO();
    private String form;
    private final int FORM_INSERT = 1;
    private final int FORM_DETAIL = 2;
    private final int FORM_UPDATE = 3;
    private final int FORM_ORDERBY_ID = 1;
    private final int FORM_ORDERBY_NOME = 2;
    private final int FORM_ORDERBY_DURACAO = 3;

    public cdService() {
        makeForm();
    }

    public void makeForm() {
        makeForm(FORM_INSERT, new cd(), FORM_ORDERBY_NOME);
    }

    public void makeForm(int orderBy) {
        makeForm(FORM_INSERT, new cd(), orderBy);
    }

    public void makeForm(int tipo, cd cd, int orderBy) {
        String nomeArquivo = "form.html";
        form = "";
        try {
            Scanner entrada = new Scanner(new File(nomeArquivo));
            while (entrada.hasNext()) {
                form += (entrada.nextLine() + "\n");
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String umCd = "";
        if (tipo != FORM_INSERT) {
            umCd += "\t<table width=\"80%\" bgcolor=\"#f3f3f3\" align=\"center\">";
            umCd += "\t\t<tr>";
            umCd += "\t\t\t<td align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;<a href=\"/cd/list/1\">Novo Cd</a></b></font></td>";
            umCd += "\t\t</tr>";
            umCd += "\t</table>";
            umCd += "\t<br>";
        }

        if (tipo == FORM_INSERT || tipo == FORM_UPDATE) {
            String action = "/cd/";
            String nome, genero, buttonLabel;
            if (tipo == FORM_INSERT) {
                action += "insert";
                nome = "Inserir Cd";
                genero = "Pop, Rock, ...";
                buttonLabel = "Inserir";
            } else {
                action += "update/" + cd.getId();
                nome = "Atualizar cd (ID " + cd.getId() + ")";
                genero = cd.getGenero();
                buttonLabel = "Atualizar";
            }
            umCd += "\t<form class=\"form--register\" action=\"" + action + "\" method=\"post\" id=\"form-add\">";
            umCd += "\t<table width=\"80%\" bgcolor=\"#f3f3f3\" align=\"center\">";
            umCd += "\t\t<tr>";
            umCd += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;" + nome
                    + "</b></font></td>";
            umCd += "\t\t</tr>";
            umCd += "\t\t<tr>";
            umCd += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
            umCd += "\t\t</tr>";
            umCd += "\t\t<tr>";
            umCd += "\t\t\t<td>&nbsp;Nome: <input class=\"input--register\" type=\"text\" name=\"nome\" value=\"" + nome
                    + "\"></td>";
            umCd += "\t\t\t<td>Duração: <input class=\"input--register\" type=\"text\" name=\"duracao\" value=\""
                    + cd.getDuracao() + "\"></td>";
            umCd += "\t\t\t<td>Gênero: <input class=\"input--register\" type=\"text\" name=\"genero\" value=\"" + genero
                    + "\"></td>";
            umCd += "\t\t</tr>";
            umCd += "\t\t<tr>";
            umCd += "\t\t\t<td>&nbsp;Data de fabricação: <input class=\"input--register\" type=\"text\" name=\"dataFabricacao\" value=\""
                    + cd.getDataFabricacao().toString() + "\"></td>";
            umCd += "\t\t\t<td>Data de lançamento: <input class=\"input--register\" type=\"text\" name=\"dataLancamento\" value=\""
                    + cd.getDataLancamento().toString() + "\"></td>";
            umCd += "\t\t\t<td align=\"center\"><input type=\"submit\" value=\"" + buttonLabel
                    + "\" class=\"input--main__style input--button\"></td>";
            umCd += "\t\t</tr>";
            umCd += "\t</table>";
            umCd += "\t</form>";
        } else if (tipo == FORM_DETAIL) {
            umCd += "\t<table width=\"80%\" bgcolor=\"#f3f3f3\" align=\"center\">";
            umCd += "\t\t<tr>";
            umCd += "\t\t\t<td colspan=\"3\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;Detalhar Cd (ID "
                    + cd.getId() + ")</b></font></td>";
            umCd += "\t\t</tr>";
            umCd += "\t\t<tr>";
            umCd += "\t\t\t<td colspan=\"3\" align=\"left\">&nbsp;</td>";
            umCd += "\t\t</tr>";
            umCd += "\t\t<tr>";
            umCd += "\t\t\t<td>&nbsp;Nome: " + cd.getNome() + "</td>";
            umCd += "\t\t\t<td>Duração: " + cd.getDuracao() + "</td>";
            umCd += "\t\t\t<td>Gênero: " + cd.getGenero() + "</td>";
            umCd += "\t\t</tr>";
            umCd += "\t\t<tr>";
            umCd += "\t\t\t<td>&nbsp;Data de fabricação: " + cd.getDataFabricacao().toString() + "</td>";
            umCd += "\t\t\t<td>Data de lançamento: " + cd.getDataLancamento().toString() + "</td>";
            umCd += "\t\t\t<td>&nbsp;</td>";
            umCd += "\t\t</tr>";
            umCd += "\t</table>";
        } else {
            System.out.println("ERRO! Tipo não identificado " + tipo);
        }
        form = form.replaceFirst("<UM-Cd>", umCd);

        String list = new String("<table width=\"80%\" align=\"center\" bgcolor=\"#f3f3f3\">");
        list += "\n<tr><td colspan=\"6\" align=\"left\"><font size=\"+2\"><b>&nbsp;&nbsp;&nbsp;Relação de cds</b></font></td></tr>\n"
                +
                "\n<tr><td colspan=\"6\">&nbsp;</td></tr>\n" +
                "\n<tr>\n" +
                "\t<td><a href=\"/cd/list/" + FORM_ORDERBY_ID + "\"><b>ID</b></a></td>\n" +
                "\t<td><a href=\"/cd/list/" + FORM_ORDERBY_NOME + "\"><b>Nome</b></a></td>\n" +
                "\t<td><a href=\"/cd/list/" + FORM_ORDERBY_DURACAO + "\"><b>Duração</b></a></td>\n" +
                "\t<td width=\"100\" align=\"center\"><b>Detalhar</b></td>\n" +
                "\t<td width=\"100\" align=\"center\"><b>Atualizar</b></td>\n" +
                "\t<td width=\"100\" align=\"center\"><b>Excluir</b></td>\n" +
                "</tr>\n";

        List<cd> cds;
        if (orderBy == FORM_ORDERBY_ID) {
            cds = cdDAO.getOrderByID();
        } else if (orderBy == FORM_ORDERBY_NOME) {
            cds = cdDAO.getOrderByNome();
        } else if (orderBy == FORM_ORDERBY_DURACAO) {
            cds = cdDAO.getOrderByDuracao();
        } else {
            cds = cdDAO.get();
        }

        int i = 0;
        String bgcolor = "";
        for (cd c : cds) {
            bgcolor = (i++ % 2 == 0) ? "#fff5dd" : "#dddddd";
            list += "\n<tr bgcolor=\"" + bgcolor + "\">\n" +
                    "\t<td>" + c.getId() + "</td>\n" +
                    "\t<td>" + c.getNome() + "</td>\n" +
                    "\t<td>" + c.getDuracao() + "</td>\n" +
                    "\t<td align=\"center\" valign=\"middle\"><a href=\"/filme/" + f.getId()
                    + "\"><img src=\"/image/detail.png\" width=\"20\" height=\"20\"/></a></td>\n" +
                    "\t<td align=\"center\" valign=\"middle\"><a href=\"/filme/update/" + f.getId()
                    + "\"><img src=\"/image/update.png\" width=\"20\" height=\"20\"/></a></td>\n" +
                    "\t<td align=\"center\" valign=\"middle\"><a href=\"javascript:confirmarDeleteFilme('" + c.getId()
                    + "', '" + c.getNome() + "', '" + c.getDuracao()
                    + "');\"><img src=\"/image/delete.png\" width=\"20\" height=\"20\"/></a></td>\n" +
                    "</tr>\n";
        }
        list += "</table>";
        form = form.replaceFirst("<LISTAR-FILME>", list);
    }

    public Object insert(Request request, Response response) {
        String nome = request.queryParams("nome");
        float duracao = Float.parseFloat(request.queryParams("duracao"));
        String genero = request.queryParams("genero");
        LocalDateTime dataFabricacao = LocalDateTime.parse(request.queryParams("dataFabricacao"));
        LocalDate dataLancamento = LocalDate.parse(request.queryParams("dataLancamento"));

        String resp = "";

        cd cd = new cd(-1, nome, duracao, genero, dataFabricacao, dataLancamento);

        if (cdDAO.insert(cd)) {
            resp = "cd (" + nome + ") inserido!";
            response.status(201); // 201 Created
        } else {
            resp = "cd (" + nome + ") não inserido!";
            response.status(404); // 404 Not found
        }

        makeForm();
        return form.replaceFirst("<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"\">",
                "<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"" + resp + "\">");
    }

    public Object get(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        cd cd = cdDAO.get(id);

        if (cd != null) {
            response.status(200); // success
            makeForm(FORM_DETAIL, cd, FORM_ORDERBY_NOME);
        } else {
            response.status(404); // 404 Not found
            String resp = "cd " + id + " não encontrado.";
            makeForm();
            form.replaceFirst("<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"\">",
                    "<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"" + resp + "\">");
        }

        return form;
    }

    public Object getToUpdate(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        cd cd = cdDAO.get(id);

        if (cd != null) {
            response.status(200); // success
            makeForm(FORM_UPDATE, cd, FORM_ORDERBY_NOME);
        } else {
            response.status(404); // 404 Not found
            String resp = "Filme " + id + " não encontrado.";
            makeForm();
            form.replaceFirst("<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"\">",
                    "<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"" + resp + "\">");
        }

        return form;
    }

    public Object getAll(Request request, Response response) {
        int orderBy = Integer.parseInt(request.params(":orderby"));
        makeForm(orderBy);
        response.header("Content-Type", "text/html");
        response.header("Content-Encoding", "UTF-8");
        return form;
    }

    public Object update(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        cd cd = cdDAO.get(id);
        String resp = "";

        if (cd != null) {
            cd.setNome(request.queryParams("nome"));
            cd.setDuracao(Float.parseFloat(request.queryParams("duracao")));
            cd.setGenero(request.queryParams("genero"));
            cd.setDataFabricacao(LocalDateTime.parse(request.queryParams("dataFabricacao")));
            cd.setDataLancamento(LocalDate.parse(request.queryParams("dataLancamento")));
            cdDAO.update(cd);
            response.status(200); // success
            resp = "Cd (ID " + cd.getId() + ") atualizado!";
        } else {
            response.status(404); // 404 Not found
            resp = "Cd (ID " + cd.getId() + ") não encontrado!";
        }
        makeForm();
        return form.replaceFirst("<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"\">",
                "<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"" + resp + "\">");
    }

    public Object delete(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        cd cd = cdDAO.get(id);
        String resp = "";

        if (cd != null) {
            cdDAO.delete(id);
            response.status(200); // success
            resp = "Cd (" + id + ") excluído!";
        } else {
            response.status(404); // 404 Not found
            resp = "Cd (" + id + ") não encontrado!";
        }
        makeForm();
        return form.replaceFirst("<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"\">",
                "<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"" + resp + "\">");
    }
}
