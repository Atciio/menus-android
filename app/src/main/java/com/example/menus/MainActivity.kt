package com.example.menus

import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configuración de la Toolbar para que actúe como ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configuración del botón para el Menú Popup
        val popupButton: Button = findViewById(R.id.btn_popup)
        popupButton.setOnClickListener { view ->
            showPopupMenu(view)
        }

        // Configuración del botón para el Menú Contextual
        val contextButton: Button = findViewById(R.id.btn_contextual)
        registerForContextMenu(contextButton)
    }

    // Configuración del Menú de Opciones
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)  // Cargar el archivo de menú
        return true
    }

    // Manejar la selección de un ítem en el menú de opciones
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Opción: Settings", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_profile -> {
                Toast.makeText(this, "Opción: Profile", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_logout -> {
                Toast.makeText(this, "Opción: Logout", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Mostrar el Menú Popup
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.popup_save -> {
                    Toast.makeText(this, "Opción: Save", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.popup_open -> {
                    Toast.makeText(this, "Opción: Open", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.popup_close -> {
                    Toast.makeText(this, "Opción: Close", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
    }

    // Configuración del Menú Contextual
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.context_edit -> {
                Toast.makeText(this, "Opción: Edit", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.context_delete -> {
                Toast.makeText(this, "Opción: Delete", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.context_share -> {
                Toast.makeText(this, "Opción: Share", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}


