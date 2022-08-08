/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Models.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Daokh
 */
public interface userService {
    List<User> SelectCus();
    Object readObj(String path)throws FileNotFoundException, IOException, ClassNotFoundException ;
    void writeObj(String path, Object data) throws FileNotFoundException, IOException ;
}
