package com.app.flowerui.utils

import com.app.flowerui.R
import com.app.flowerui.modal.CategoryItemModule
import com.app.flowerui.modal.FlowerItemModal
import com.app.flowerui.modal.SliderModal

fun SliderList() = listOf<SliderModal>(
    SliderModal(icon = R.drawable.ic_sale_banner, pageNumber = 1),
    SliderModal(icon = R.drawable.ic_sale_banner, pageNumber = 2),
    SliderModal(icon = R.drawable.ic_sale_banner, pageNumber = 3),
    SliderModal(icon = R.drawable.ic_sale_banner, pageNumber = 4),
    SliderModal(icon = R.drawable.ic_sale_banner, pageNumber = 5)
)

fun CategoryListItem() = listOf<CategoryItemModule>(
    CategoryItemModule(icon = R.drawable.ic_wedding_arch),
    CategoryItemModule(icon = R.drawable.ic_chinese_plum_flower),
    CategoryItemModule(icon = R.drawable.ic_flat_flower),
    CategoryItemModule(icon = R.drawable.ic_giftbox)
)

fun FlowersList() = listOf<FlowerItemModal>(
    FlowerItemModal(flowerImages = R.drawable.ic_red_rose_bouquet, name = "Angle", price = 65),
    FlowerItemModal(flowerImages = R.drawable.ic_pink_rose_bouquet, name = "Jannien", price = 12),
    FlowerItemModal(flowerImages = R.drawable.ic_red_rose_bouquet, name = "Red Rose", price = 65),
    FlowerItemModal(flowerImages = R.drawable.ic_pink_rose_bouquet, name = "Pink Rose", price = 12),
    FlowerItemModal(flowerImages = R.drawable.ic_red_rose_bouquet, name = "Angle", price = 128),
    FlowerItemModal(flowerImages = R.drawable.ic_pink_rose_bouquet, name = "Rose", price = 12),
)

fun PopularFlowersList() = listOf<FlowerItemModal>(
    FlowerItemModal(flowerImages = R.drawable.ic_red_rose_bouquet, name = "Angle", price = 65),
    FlowerItemModal(flowerImages = R.drawable.ic_pink_rose_bouquet, name = "Jannien", price = 12),
    FlowerItemModal(flowerImages = R.drawable.ic_red_rose_bouquet, name = "Red Rose", price = 65),
    FlowerItemModal(flowerImages = R.drawable.ic_pink_rose_bouquet, name = "Pink Rose", price = 12),
    FlowerItemModal(flowerImages = R.drawable.ic_red_rose_bouquet, name = "Angle", price = 128),
    FlowerItemModal(flowerImages = R.drawable.ic_pink_rose_bouquet, name = "Rose", price = 12),
    FlowerItemModal(flowerImages = R.drawable.ic_red_rose_bouquet, name = "Angle", price = 65),
    FlowerItemModal(flowerImages = R.drawable.ic_pink_rose_bouquet, name = "Jannien", price = 12),
    FlowerItemModal(flowerImages = R.drawable.ic_red_rose_bouquet, name = "Red Rose", price = 65),
    FlowerItemModal(flowerImages = R.drawable.ic_pink_rose_bouquet, name = "Pink Rose", price = 12),
    FlowerItemModal(flowerImages = R.drawable.ic_red_rose_bouquet, name = "Angle", price = 128),
    FlowerItemModal(flowerImages = R.drawable.ic_pink_rose_bouquet, name = "Rose", price = 12),
)