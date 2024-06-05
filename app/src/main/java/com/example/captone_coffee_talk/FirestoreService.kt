import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot

class FirestoreService {
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getCollectionDocuments(collectionName: String?) {
        val collection = db.collection(collectionName!!)
        collection.get()
            .addOnSuccessListener { querySnapshot ->
                val documents = querySnapshot.documents
                for (document in documents) {
                    println("Document ID: ${document.id}")
                    println("Document Data: ${document.data}")
                }
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }

    fun getDocument(collectionName: String?, documentId: String?) {
        val docRef = db.collection(collectionName!!).document(documentId!!)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    println("Document Data: ${document.data}")
                } else {
                    println("No such document!")
                }
            }
            .addOnFailureListener { e ->
                e.printStackTrace()
            }
    }
}
