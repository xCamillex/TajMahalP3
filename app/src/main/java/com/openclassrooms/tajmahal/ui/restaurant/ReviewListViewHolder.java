package com.openclassrooms.tajmahal.ui.restaurant;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.openclassrooms.tajmahal.databinding.FragmentReviewItemBinding;
import com.openclassrooms.tajmahal.domain.model.Review;

public class ReviewListViewHolder extends RecyclerView.ViewHolder {
    private Review review;
    private FragmentReviewItemBinding binding;
    public ReviewListViewHolder(@NonNull View itemView) {
        super(itemView);
        binding = FragmentReviewItemBinding.bind(itemView);
    }

    public void setReview(Review review) {
        this.review = review;
        binding.tvReviewComment.setText(review.getComment());
        Glide.with(binding.ivItemAvatar.getContext())
                .load(review.getPicture())
                .centerCrop()
                .into(binding.ivItemAvatar);
        binding.tvItemName.setText(review.getUsername());
        binding.rbItemRate.setRating(review.getRate());
    }
}

