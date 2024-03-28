import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tripparcel.model.TripModel
import com.example.tripparcel.repository.GenericRepository
import com.example.tripparcel.utilities.seedTripToFirestore
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val firestoreInstance: FirebaseFirestore by lazy {
        FirebaseFirestore.getInstance()
    }

    private val tripCollectionRef = firestoreInstance.collection("Trips")
    private val repository = GenericRepository(tripCollectionRef, TripModel::class.java)

    val items = mutableStateOf<List<TripModel>>(emptyList())
    val error = mutableStateOf<Boolean>(false)
    val tripLoading = mutableStateOf<Boolean>(false)
    val errorMessage = mutableStateOf<String?>("")


init{
   //seederOperation
    loadTrip()
}

    fun seederOperation(){

        seedTripToFirestore(repository)
    }

    fun loadTrip() {
        tripLoading.value= true;
        error.value= false;
        viewModelScope.launch {
            repository.getData(
                onSuccess = { itemsList ->
                    tripLoading.value= false;
                    error.value= false;
                    items.value = itemsList
                },
                onFailure = { exception ->
                    tripLoading.value= false;
                    error.value= true;
                    errorMessage.value = exception.message
                }
            )
        }
    }

    // Supprimer un élément
    fun deleteTrip(itemId: String) {
        viewModelScope.launch {
            repository.deleteData(
                itemId,
                onSuccess = {
                    error.value= false;
                    tripLoading.value= false;
                },
                onFailure = { exception ->
                    error.value= true;
                    tripLoading.value= false;
                    errorMessage.value = exception.message
                }
            )
        }
    }
}