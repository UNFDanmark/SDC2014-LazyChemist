package dk.unfsdc.Lazy_Chemist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sdc on 7/17/14.
 */
public class AtomAdapter extends BaseAdapter {

    ArrayList<Atom> atoms;
    Context context;

    public AtomAdapter(ArrayList<Atom> atoms, Context context) {
        this.atoms = atoms;
        this.context = context;
    }

    @Override
    public int getCount() {
        return atoms.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(context);

        tv.setText(atoms.get(position).getName1());

        return tv;
    }
}
