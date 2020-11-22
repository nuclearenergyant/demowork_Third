package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weige.UI.R;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Bill;

public class CardviewForbillAdapter extends RecyclerView.Adapter<CardviewForbillAdapter.ViewHolder> {
    private Context context;
    private List<Bill>list;

    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView textView_time_state;
        TextView textView_date;
        TextView phone_for_bill;
        TextView price_for_bill;
        TextView address_for_bill;
        Button button_to_see_all_bill;
        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            cardView= (CardView) itemView;
            textView_date=itemView.findViewById( R.id.time_bill );
            textView_time_state=itemView.findViewById( R.id.time_state );

            phone_for_bill=itemView.findViewById( R.id.phone_for_bill );
            price_for_bill=itemView.findViewById( R.id.price_for_bill );
            address_for_bill=itemView.findViewById( R.id.address_for_bill );
            button_to_see_all_bill=itemView.findViewById( R.id.see_all_bill_message );
        }
    }
    //构造方法
    public CardviewForbillAdapter (List<Bill> list_a){
        this.list=list_a;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(context==null){
            context=viewGroup.getContext();
        }
        View view= LayoutInflater.from( context ).inflate( R.layout.cardview_for_bill,viewGroup,false );
        //测试
        final  ViewHolder holder =new ViewHolder( view );

        //对查看订单所有信息设置监听事件
        holder.button_to_see_all_bill.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=holder.getAdapterPosition();
                Bill bill=list.get( p );

                new FancyGifDialog.Builder( (Activity) context )
                        .setTitle("Granny eating chocolate dialog box")
//                        .setMessage("This is a granny eating chocolate dialog box. This library is used to help you easily create fancy gify dialog.")

                        .setMessage( "订单地址："+bill.getBill_address()
                                +'\n' +'\n'+"订单电话："+bill.getPhone()
                                +'\n' +'\n'+"下单时间："+new SimpleDateFormat( "yyyy-MM-dd    HH:mm:ss" ).format(bill.getDate() )
                                +'\n' +'\n'+"订单价格："+bill.getPrice()
                                +'\n' +'\n'+"垃圾回收返款："+bill.getPrice_forcustomer()
                                +'\n' +'\n'+"回收总部：华广c19"+bill.getHeadquarters()
                        )
                        .setNegativeBtnText("投诉")
                        .setPositiveBtnBackground("#FF4081")
                        .setPositiveBtnText("退下")
                        .setNegativeBtnBackground("#FFA9A7A8")
                        .setGifResource(R.drawable.gif1)   //Pass your Gif here
                        .isCancellable(true)
                        .OnPositiveClicked(new FancyGifDialogListener() {
                            @Override
                            public void OnClick() {
                                //退下按钮监听事件
//                                Toast.makeText(context,"Ok",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .OnNegativeClicked(new FancyGifDialogListener() {
                            @Override
                            public void OnClick() {
                                //投诉按钮监听事件
                                Toast.makeText(context,"投诉",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        } );
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Bill bill=list.get( i );
        viewHolder.phone_for_bill.setText( "下单手机号码："+bill.getPhone() );
        viewHolder.price_for_bill.setText( "下单费用："+ bill.getPrice() );
        viewHolder.textView_time_state.setText( bill.getState() );
        viewHolder.address_for_bill.setText( "下单地址："+ bill.getBill_address());
        String time=new SimpleDateFormat( "yyyy-MM-dd    HH:mm:ss" ).format( bill.getDate() );
        viewHolder.textView_date.setText("下单时间："+time);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
