package com.gestock.gestock.services;

import com.gestock.gestock.persistence.entity.UserEntity;
import com.gestock.gestock.persistence.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /* Obtener todos
    * @return La lista de usuarios encontrados en la base de datos
    * */
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    /* Obtener por id. Se usa optional para manejar los casos en el que no existe el usuario.
    * @param userId Id del usuario a buscar
    * @return El usuario, vacio si no existe.
    * */
    public Optional<UserEntity> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }

    /* Obtener por email
    * @param email El email por el cual se buscara el usuario
    * @return El usuario encontrado
    * */
    public UserEntity getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /* Verificar si existe por email
    * @param email El email del usuario a buscar y verificar si existe
    * @return True si fue encontrado el usuario, false si no.
    * */
    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    /* Create y update user. Transactional indica que es un metodo que actualiza o crea un registro.
    * @param user El objeto userEntity a guardar o actualizar
    * @return El usuario guardado o actualizado
    * */
    @Transactional
    public UserEntity saveUser(UserEntity user) {
        return userRepository.save(user);
    }

    /* Actualizar un usuario existente
    * @param userId ID del usuario a actualizar
    * @param userDetails un objeto UserEntity con los cambios nuevos a actualizar
    * @return Usuario actualizado o vacio si no existe
    * */

    @Transactional
    public Optional<UserEntity> updateUser(Integer userId, UserEntity userDetails) {
        return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setName(userDetails.getName());
                    existingUser.setEmail(userDetails.getEmail());
                    // La contraseña se actualiza en otro metodo, para mas seguridad
                    return userRepository.save(existingUser);
                });
    }

    /* Actualizar contraseña
    * @param userId Id del usuario que actualizara contraseña
    * @param newPassword La nueva contraseña que reemplazara la anterior
    * @return true si se actualizo la contraseña, false si no se encontró
    *  */
    @Transactional
    public boolean updatePassword(Integer userId, String newPassword) {
        return userRepository.findById(userId)
                .map(user -> {
                    user.setPassword(newPassword);
                    userRepository.save(user);
                    return true;
                }).orElse(false);
    }

    /* Eliminar un usuario por id
    * @param id ID del usuario a eliminar
    * @return true si se elimino correctamente, false si no se encontro el usuario.
    * */
    @Transactional
    public boolean deleteUser(Integer userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return true;
                }).orElse(false);
    }

}
