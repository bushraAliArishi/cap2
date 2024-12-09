package com.example.medicalherbs.Service;

import com.example.medicalherbs.ApiResponse.ApiException;
import com.example.medicalherbs.Model.User;
import com.example.medicalherbs.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new ApiException("User not found");
        }
        return user;
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("User not found");
        }
        return user;
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setUsername(user.getUsername());
            existing.setEmail(user.getEmail());
            existing.setRole(user.getRole());
            userRepository.save(existing);
        } else {
            throw new ApiException("User not found");
        }
    }

    public void deleteUser(Integer id) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing != null) {
            userRepository.delete(existing);
        } else {
            throw new ApiException("User not found");
        }
    }
}
