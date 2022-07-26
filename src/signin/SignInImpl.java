/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package signin;

/**
 *
 * @author Daokh
 */
public interface SignInImpl {
   void dangnhap(); // check du lieu dua vao cung voi database
   void checkValidate(String user1, int a); // check du lieu hop le
   void connect(); // database
   void Remember(); // luu pass
   void FilltoList();
}
