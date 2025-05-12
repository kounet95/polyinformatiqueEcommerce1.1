param (
    [string]$Commit = "HEAD"
)

Write-Host "🔍 Fermeture d'IntelliJ IDEA (si ouvert)..."
Get-Process -Name idea64 -ErrorAction SilentlyContinue | Stop-Process -Force

Write-Host "🧹 Suppression du dossier .idea..."
if (Test-Path ".idea") {
    Remove-Item -Recurse -Force ".idea"
}

Write-Host "🔁 Reset hard vers le commit $Commit"
git reset --hard $Commit
