import com.google.firebase.firestore.FirebaseFirestore

object FirestoreManager {
    private var firestore: FirebaseFirestore? = null

    fun initialize() {
        firestore = FirebaseFirestore.getInstance()
    }

    fun getFirestore(): FirebaseFirestore {
        return firestore ?: throw IllegalStateException("Firestore is not initialized")
    }
}
