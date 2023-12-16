# Casino Simulation

* **Objective** - To create an casino simulation
* **Purpose** - To gain familiarity with general object orientation and design principles
* **Games implemented by Me** - Slot machine and Chohan dice game

Also worked on a player and account management system.


* **Description**
    * Created a casino simulation by extending or removing the pre-built implementations.
    * Enforced the following features in the system:
        * Ensure a console-based interface is available to allow input from and output to the users
        * Ensure the `Casino` has a selection of at least 6 implementation of `GameInterface`.
        * Ensure `PlayerInterface` is garbage collected upon completing a respective `GameInterface`
            * `SlotsPlayer` should be garbage collected when `SlotsGame` is garbage collected.
            * `BlackJackPlayer` should be garbage collected when `BlackJackGame` is garbage collected.
        * Ensure all implementation of `PlayerInterface` have reference to a `CasinoAccount`
            * `CasinoAccount` should not be garbage collected when a `GameInterface` is garbage collected.
        * Ensure at least 6 different implementations of `GameInterface` and a respective `PlayerInterface` are defined.
        * Ensure at least 1 implementation of `GameInterface` does not involve gambling.
        * Ensure at least 3 implementations of `GameInterface` involve gambling.
