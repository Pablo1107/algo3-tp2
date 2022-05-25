{
  description = "algo3-tp2";

  outputs = { self, nixpkgs }:
    let
      # # Generate a user-friendly version number.
      # # version = builtins.substring 0 8 self.lastModifiedDate;
      #
      # # System types to support.
      # supportedSystems = [ "x86_64-linux" "x86_64-darwin" "aarch64-linux" "aarch64-darwin" ];
      #
      # # Helper function to generate an attrset '{ x86_64-linux = f "x86_64-linux"; ... }'.
      # forAllSystems = nixpkgs.lib.genAttrs supportedSystems;
      #
      # # Nixpkgs instantiated for supported system types.
      # nixpkgsFor = forAllSystems (system: import nixpkgs { inherit system; });
      #
      pkgs = nixpkgs.legacyPackages.x86_64-linux;
    in
    {
      devShell."x86_64-linux" =
        pkgs.mkShell {
          buildInputs = with pkgs; [
            openjdk11
            maven
          ];

          # shellHook = ''
          #   zsh && exit
          # '';
        };
    };
}
