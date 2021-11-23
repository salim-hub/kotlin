import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

// Since the dataset will be only used within this class, make it private.
class ItemAdapter (
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    // The onCreateViewHolder() method is called by the layout manager to create new view holders for the RecyclerView
    // (when there are no existing view holders that can be reused). Remember that a view holder represents a single list item view.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        // The third boolean argument is attachToRoot. This argument needs to be false,
        // because RecyclerView adds this item to the view hierarchy for you when it's time.
        return ItemViewHolder(adapterLayout)
    }

    // onBindViewHolder() method is called by the layout manager in order to replace the contents of a list item view.
    // In this method, you will find the right Affirmation object from the data set based on position.
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    // The getItemCount() method needs to return the size of your dataset.
    override fun getItemCount() = dataset.size
}