package com.example.pp4_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AddItemToDataBasePage : AppCompatActivity() {

   private lateinit var etName : EditText
   private lateinit var etBrand : EditText
   private lateinit var etType : EditText
   private lateinit var etPrice : EditText
   private lateinit var  etAmount: EditText
   lateinit var addBtn : Button
   private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item_to_data_base_page)

        //Linking to var to buttons so we cab get the data
        etName = findViewById(R.id.addItemName)
        etBrand = findViewById(R.id.addItemBrand)
        etType = findViewById(R.id.addItemType)
        etPrice = findViewById(R.id.addItemPrice)
        etAmount = findViewById(R.id.addItemAmount)
        addBtn = findViewById(R.id.addItemButton)

        // DB Reference
        dbRef = FirebaseDatabase.getInstance().getReference("Items")

        addBtn.setOnClickListener(){

            addingItems()
        }


    }

    private fun addingItems() {

        val name = etName.text.toString()
        val brand = etBrand.text.toString()
        val type = etType.text.toString()
        val price = etPrice.text.toString()
        val amount = etAmount.text.toString()


        if ( name.isEmpty() && brand.isEmpty() && type.isEmpty() && price.isEmpty() && amount.isEmpty()){

            Toast.makeText(this,"Please fill all areas", Toast.LENGTH_LONG).show()

        }
        if ( name.isNotEmpty() && brand.isNotEmpty() && type.isNotEmpty() && price.isNotEmpty() && amount.isNotEmpty()){

            val itemsData = ItemsDataModel(name,brand,type,price,amount)

            dbRef.child(name).setValue(itemsData).addOnSuccessListener {


                etName.text.clear()
                etBrand.text.clear()
                etType.text.clear()
                etPrice.text.clear()
                etAmount.text.clear()

                Toast.makeText(applicationContext,"Item Added Successfully",Toast.LENGTH_LONG).show()

            }.addOnFailureListener{
                Toast.makeText(applicationContext,"Failed To add Item",Toast.LENGTH_LONG).show()

            }

        }

    }
}