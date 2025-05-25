package com.todos;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.stereotype.Service;

@Service
public class FirebaseAuthService {

    public String verifyIdTokenAndGetUid(String idToken) {
        try {
            // Обычно токен приходит в формате "Bearer eyJhbGciOiJSUzI1NiIs..."
            String cleanToken = idToken.startsWith("Bearer ") ? idToken.substring(7) : idToken;
            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(cleanToken);
            return decodedToken.getUid();
        } catch (Exception e) {
            throw new RuntimeException("Invalid Firebase ID token");
        }
    }
}