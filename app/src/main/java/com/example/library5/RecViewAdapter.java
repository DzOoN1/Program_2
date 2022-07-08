package com.example.library5;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.ViewHolder> {

    ArrayList<Book> books = new ArrayList<>();
    Context mContext;

    public RecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.one_book_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(books.get(position).getImageURL()).into(holder.image);
        holder.txtBookName.setText(books.get(position).getBookName());
        holder.txtAuthor.setText(books.get(position).getAuthor());
        holder.txtPages.setText(String.valueOf(books.get(position).getPages()));
        holder.txtDescription.setText(books.get(position).getDescription());

       if(books == DataBase.getAllBooks()){
           holder.btnDelete.setVisibility(View.GONE);

        }
       else if (books == DataBase.getReadBooks()){
           holder.btnDelete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   DataBase.getInstance().removeFromRead(books.get(position));
                   Toast.makeText(mContext,"Book removed!",Toast.LENGTH_SHORT).show();
                   notifyDataSetChanged();
               }
           });

       }
       else if(books == DataBase.getNotReadBooks()){
           holder.btnDelete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   DataBase.getInstance().removeFromNotRead(books.get(position));
                   Toast.makeText(mContext,"Book removed!",Toast.LENGTH_SHORT).show();
                   notifyDataSetChanged();
               }
           });
       }
        if(books.get(position).isExpanded()){
            holder.expandedLayout.setVisibility(View.VISIBLE);
            holder.down_arrow.setVisibility(View.GONE);
        }
        if(!books.get(position).isExpanded()){
            holder.expandedLayout.setVisibility(View.GONE);
            holder.down_arrow.setVisibility(View.VISIBLE);
        }


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,BookActivity.class);
                intent.putExtra("bookID",books.get(position).getID());
                mContext.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image, up_arrow, down_arrow;
        private TextView txtBookName, txtAuthor, txtPages,txtDescription, btnDelete;
        private RelativeLayout expandedLayout;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            up_arrow = itemView.findViewById(R.id.btnUpArrow);
            down_arrow = itemView.findViewById(R.id.btnDownArrow);
            txtBookName=itemView.findViewById(R.id.txtBookName);
            txtAuthor =itemView.findViewById(R.id.txtAuthor);
            txtPages=itemView.findViewById(R.id.txtPages);
            txtDescription=itemView.findViewById(R.id.txtDescription);
            btnDelete=itemView.findViewById(R.id.btnDelete);
            parent = itemView.findViewById(R.id.parent);
            expandedLayout = itemView.findViewById(R.id.expandedLayout);

            down_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    if(!book.isExpanded()){
                        book.setExpanded(true);
                        notifyDataSetChanged();
                    }


                }
            });
            up_arrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Book book = books.get(getAdapterPosition());
                    if(book.isExpanded()){
                        book.setExpanded(false);
                        notifyDataSetChanged();
                    }

                }
            });

        }
    }
}
