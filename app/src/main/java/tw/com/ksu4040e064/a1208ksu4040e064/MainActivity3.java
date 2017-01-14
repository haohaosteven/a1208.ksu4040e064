package tw.com.ksu4040e064.a1208ksu4040e064;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setTitle("產品管理系統");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(
                        2, StaggeredGridLayoutManager.HORIZONTAL));
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Member(92, R.drawable.b05, "James"));
        memberList.add(new Member(103, R.drawable.b06, "David"));
        memberList.add(new Member(234, R.drawable.b09, "Jerry"));
        memberList.add(new Member(35, R.drawable.b10, "Maggie"));
        memberList.add(new Member(23, R.drawable.b01, "John"));
        memberList.add(new Member(75, R.drawable.b02, "Jack"));
        memberList.add(new Member(65, R.drawable.b03, "Mark"));
        memberList.add(new Member(12, R.drawable.b04, "Ben"));
        memberList.add(new Member(45, R.drawable.b07, "Ken"));
        memberList.add(new Member(78, R.drawable.b08, "Ron"));
        memberList.add(new Member(57, R.drawable.b11, "Sue"));
        memberList.add(new Member(61, R.drawable.b12, "Cathy"));
        recyclerView.setAdapter(new MemberAdapter(this, memberList));
    }

    private class MemberAdapter extends
            RecyclerView.Adapter<MemberAdapter.ViewHolder> {
        private Context context;
        private LayoutInflater layoutInflater;
        private List<Member> memberList;

        public MemberAdapter(Context context, List<Member> memberList) {
            this.context = context;
            layoutInflater = LayoutInflater.from(context);
            this.memberList = memberList;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivImage;
            TextView tvId, tvName;

            public ViewHolder(View itemView) {
                super(itemView);
                ivImage = (ImageView) itemView.findViewById(R.id.ivImage);
                tvId = (TextView) itemView.findViewById(R.id.tvId);
                tvName = (TextView) itemView.findViewById(R.id.tvName);
            }
        }

        @Override
        public int getItemCount() {
            return memberList.size();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View itemView = layoutInflater.inflate(
                    R.layout.recyclerview_cardview_item, viewGroup, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            final Member member = memberList.get(position);
            viewHolder.ivImage.setImageResource(member.getImage());
            viewHolder.tvId.setText(String.valueOf(member.getId()));
            viewHolder.tvName.setText(member.getName());
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ImageView imageView = new ImageView(context);
                    imageView.setImageResource(member.getImage());
                    Toast toast = new Toast(context);
                    toast.setView(imageView);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
    }
}
