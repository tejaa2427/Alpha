package com.example.nirbhaya

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GuardianContactsActivity : AppCompatActivity() {

    private lateinit var contactNameInput: EditText
    private lateinit var contactNumberInput: EditText
    private lateinit var contactListView: ListView
    private val contacts = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_guardian)

        contactNameInput = findViewById(R.id.et_contact_name)
        contactNumberInput = findViewById(R.id.et_contact_number)
        contactListView = findViewById(R.id.lv_contacts)
        val saveButton = findViewById<Button>(R.id.btn_save_contact)

        // Setup ListView adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contacts)
        contactListView.adapter = adapter

        saveButton.setOnClickListener {
            val name = contactNameInput.text.toString()
            val number = contactNumberInput.text.toString()

            if (name.isNotEmpty() && number.isNotEmpty()) {
                val contact = "$name: $number"
                contacts.add(contact)
                adapter.notifyDataSetChanged()

                // Clear input fields
                contactNameInput.text.clear()
                contactNumberInput.text.clear()

                Toast.makeText(this, "Contact saved!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter both name and number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
