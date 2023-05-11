// Author : Egi subastian dan fabiyan air langga

import 'dart:io';
import 'dart:math';

void main() {
  print("silahkan Masukkan Bangun Datar apa yang akan di hitung : ");
  print("1. Persegi");
  print("2. Persegi Panjang");
  print("3. Segitiga");
  print("4. Lingkaran");
  print("5. Jajar Genjang");
  print("6. Belah Ketupat");
  print("7. Trapesium");
  print("8. Layang-layang");

  stdout.write("Pilihan Anda : ");
  int pilihan = int.parse(stdin.readLineSync()!);

  switch (pilihan) {
    case 1:
      hitungPersegi();
      break;
    case 2:
      hitungPersegiPanjang();
      break;
    case 3:
      hitungSegitiga();
      break;
    case 4:
      hitungLingkaran();
      break;
    case 5:
      hitungJajarGenjang();
      break;
    case 6:
      hitungBelahKetupat();
      break;
    case 7:
      hitungTrapesium();
      break;
    case 8:
      hitungLayangLayang();
      break;
    default:
      print("Pilihan tidak valid");
  }
}

void hitungPersegi() {
  stdout.write("Masukkan panjang sisi: ");
  double sisi = double.parse(stdin.readLineSync()!);

  double luas = sisi * sisi;
  double keliling = 4 * sisi;

  print("Luas persegi: $luas");
  print("Keliling persegi: $keliling");
}

void hitungPersegiPanjang() {
  stdout.write("Masukkan panjang: ");
  double panjang = double.parse(stdin.readLineSync()!);
  stdout.write("Masukkan lebar: ");
  double lebar = double.parse(stdin.readLineSync()!);

  double luas = panjang * lebar;
  double keliling = 2 * (panjang + lebar);

  print("Luas persegi panjang: $luas");
  print("Keliling persegi panjang: $keliling");
}

void hitungSegitiga() {
  stdout.write("Masukkan alas: ");
  double alas = double.parse(stdin.readLineSync()!);
  stdout.write("Masukkan tinggi: ");
  double tinggi = double.parse(stdin.readLineSync()!);

  double luas = 0.5 * alas * tinggi;

  print("Luas segitiga: $luas");
}

void hitungLingkaran() {
  stdout.write("Masukkan jari-jari: ");
  double jariJari = double.parse(stdin.readLineSync()!);

  double luas = pi * jariJari * jariJari;
  double keliling = 2 * pi * jariJari;

  print("Luas lingkaran: $luas");
  print("Keliling lingkaran: $keliling");
}

void hitungJajarGenjang() {
stdout.write("Masukkan alas: ");
double alas = double.parse(stdin.readLineSync()!);
stdout.write("Masukkan tinggi: ");
double tinggi = double.parse(stdin.readLineSync()!);
stdout.write("Masukkan sisi miring: ");
double sisiMiring = double.parse(stdin.readLineSync()!);

double luas = alas * tinggi;
double keliling = 2 * (alas + sisiMiring);

print("Luas jajar genjang: $luas");
print("Keliling jajar genjang: $keliling");
}


void hitungBelahKetupat() {
stdout.write("Masukkan diagonal 1: ");
double d1 = double.parse(stdin.readLineSync()!);
stdout.write("Masukkan diagonal 2: ");
double d2 = double.parse(stdin.readLineSync()!);

double luas = 0.5 * d1 * d2;

  if(d1 != d2){
  print("Maaf, inputan salah. Silahkan coba lagi");
  } else {
  print("Luas belah ketupat: $luas");
  }
}


void hitungTrapesium() {
stdout.write("Masukkan sisi atas: ");
double sisiAtas = double.parse(stdin.readLineSync()!);
stdout.write("Masukkan sisi bawah: ");
double sisiBawah = double.parse(stdin.readLineSync()!);
stdout.write("Masukkan tinggi: ");
double tinggi = double.parse(stdin.readLineSync()!);
stdout.write("Masukkan sisi miring kiri: ");
double sisiMiringKiri = double.parse(stdin.readLineSync()!);
stdout.write("Masukkan sisi miring kanan: ");
double sisiMiringKanan = double.parse(stdin.readLineSync()!);

double luas = 0.5 * (sisiAtas + sisiBawah) * tinggi;
double keliling = sisiAtas + sisiBawah + sisiMiringKiri + sisiMiringKanan;

print("Luas trapesium: $luas");
print("Keliling trapesium: $keliling");
}

void hitungLayangLayang() {
stdout.write("Masukkan diagonal 1 : ");
double d1 = double.parse(stdin.readLineSync()!);
stdout.write("Masukkan diagonal 2 : ");
double d2 = double.parse(stdin.readLineSync()!);
double luas = 0.5 * d1 * d2;

  if( d1 == d2) {
    print("maaf inputan salah, coba lagi");
  } else {
    print("Luas layang-layang: $luas");
  }
}