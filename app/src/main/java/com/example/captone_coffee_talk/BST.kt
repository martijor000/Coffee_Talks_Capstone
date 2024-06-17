import android.util.Log
import com.example.captone_coffee_talk.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class BST {
    data class Node(val user: User, var left: Node? = null, var right: Node? = null)

    private var root: Node? = null
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    init {
        loadUsersFromFirestore()
    }

    fun insert(user: User) {
        root = insertRec(root, user)
        // Save user to Firestore
        if (!user.id.isNullOrEmpty()) {
            db.collection("user").document(user.id!!).set(user)
                .addOnSuccessListener { Log.d("BST", "User added to Firestore") }
                .addOnFailureListener { e -> Log.e("BST", "Error adding user: $e") }
        } else {
            Log.e("BST", "Invalid user ID, cannot save to Firestore")
        }
    }

    private fun insertRec(root: Node?, user: User): Node {
        if (root == null) {
            return Node(user)
        }
        if (user.name!! < root.user.name.toString()) {
            root.left = insertRec(root.left, user)
        } else if (user.name!! > root.user.name.toString()) {
            root.right = insertRec(root.right, user)
        }
        return root
    }

    fun search(name: String): List<User> {
        val result = mutableListOf<User>()
        searchRec(root, name, result)
        Log.d("BST", "Search for '$name' found ${result.size} users")
        return result
    }

    private fun searchRec(root: Node?, name: String, result: MutableList<User>) {
        if (root != null) {
            if (root.user.name?.startsWith(name, ignoreCase = true)!!) {
                result.add(root.user)
                Log.d("BST", "Found user: ${root.user.name}")
            }
            searchRec(root.left, name, result)
            searchRec(root.right, name, result)
        }
    }

    fun loadUsersFromFirestore() {
        db.collection("user").get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val user = document.toObject(User::class.java)
                    user.id = document.id  // Ensure user ID is set from document ID
                    insert(user)
                }
                Log.d("BST", "BST loaded with ${documents.size()} users from Firestore")
            }
            .addOnFailureListener { e -> Log.e("BST", "Error loading users: $e") }
    }

    fun getCurrentUser(): User? {
        val firebaseUser = auth.currentUser
        return if (firebaseUser != null) {
            User(
                uId = firebaseUser.uid,
                name = firebaseUser.displayName ?: "",
                email = firebaseUser.email ?: ""
            )
        } else {
            null
        }
    }
}

