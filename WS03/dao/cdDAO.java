package dao;

import model.cd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class cdDAO extends DAO {
    public cdDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }

    public boolean insert(cd cd) {
        boolean status = false;
        try {
            String sql = "INSERT INTO cd (genero, nome, duracao, quantidade, datafabricacao, datalancamento) "
                    + "VALUES ('" + cd.getGenero() + "', "
                    + "'" + cd.getNome() + "', " + cd.getDuracao() + ", ?, ?);";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setTimestamp(1, Timestamp.valueOf(cd.getDataFabricacao()));
            st.setDate(2, Date.valueOf(cd.getDataLancamento()));
            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    public cd get(int id) {
        cd cd = null;

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM cd WHERE id=" + id;
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                cd = new cd(rs.getInt("id"), rs.getString("nome"), (float) rs.getDouble("duracao"),
                        rs.getString("genero"),
                        rs.getTimestamp("datafabricacao").toLocalDateTime(),
                        rs.getDate("datalancamento").toLocalDate());
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cd;
    }

    public List<cd> get() {
        return get("");
    }

    public List<cd> getOrderByID() {
        return get("id");
    }

    public List<cd> getOrderByNome() {
        return get("nome");
    }

    public List<cd> getOrderByDuracao() {
        return get("duracao");
    }

    private List<cd> get(String orderBy) {
        List<cd> cds = new ArrayList<cd>();

        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM filme" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cd f = new cd(rs.getInt("id"), rs.getString("nome"), (float) rs.getDouble("duracao"),
                        rs.getString("genero"),
                        rs.getTimestamp("datafabricacao").toLocalDateTime(),
                        rs.getDate("datalancamento").toLocalDate());
                cds.add(f);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cds;
    }

    public boolean update(cd cd) {
        boolean status = false;
        try {
            String sql = "UPDATE cd SET nome = '" + cd.getNome() + "', "
                    + "duracao = " + cd.getDuracao() + ", "
                    + "genero = '" + cd.getGenero() + "', "
                    + "datafabricacao = ?, "
                    + "datalancamento = ? WHERE id = " + cd.getId();
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setTimestamp(1, Timestamp.valueOf(cd.getDataFabricacao()));
            st.setDate(2, Date.valueOf(cd.getDataLancamento()));
            st.executeUpdate();
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

    public boolean delete(int id) {
        boolean status = false;
        try {
            Statement st = conexao.createStatement();
            st.executeUpdate("DELETE FROM filme WHERE id = " + id);
            st.close();
            status = true;
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return status;
    }

}
