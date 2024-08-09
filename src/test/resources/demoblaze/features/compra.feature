Feature: Flujo de compra en Demoblaze

Scenario: Realizar compra de dos productos
  Given El usuario esta en la pagina principal de Demoblaze
  When Agrega dos productos al carrito
  And Visualiza el carrito
  And Completa el formulario de compra
  Then Finaliza la compra exitosamente
