package dms.repository;

import dms.connection.Connector;
import dms.model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javidan
 */
public class AccountRepository implements QueryRepository<Account, Integer> {

    private Connection connection;
    private PreparedStatement pst;
    private ResultSet rs;

    @Override
    public Account save(Account type) {
        this.connection = Connector.getConnection();
        String sql = "insert into users (name, surname, age, country, city, district, street, isActive, registeredAt) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(0, type.getName());
            pst.setString(1, type.getSurname());
            pst.setInt(2, type.getAge());
            pst.setString(3, type.getAddress().getCountry());
            pst.setString(4, type.getAddress().getCity());
            pst.setString(5, type.getAddress().getDistrict());
            pst.setString(6, type.getAddress().getStreet());
            pst.setBoolean(7, type.isIsActive());
            pst.setDate(8, type.getRegisteredAt());
            boolean isExecuted = pst.execute();
            if (isExecuted) {
                return type;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountRepository.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AccountRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public Account getById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Account> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Account type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account update(Account type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
