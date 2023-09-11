# https://github.com/tadfisher/android-nixpkgs
#
# nix-channel --add https://tadfisher.github.io/android-nixpkgs android-nixpkgs
# nix-channel --update android-nixpkgs

{ pkgs ? import <nixpkgs> { } }:

with pkgs;

let
  android-nixpkgs = callPackage <android-nixpkgs> { };

  android-sdk = android-nixpkgs.sdk (sdkPkgs: with sdkPkgs; [
    cmdline-tools-latest
    build-tools-34-0-0
    platform-tools
    platforms-android-34
    emulator
    system-images-android-34-google-apis-x86-64
  ]);

in
mkShell {
  buildInputs = [
    android-studio
    android-sdk
  ];
}
