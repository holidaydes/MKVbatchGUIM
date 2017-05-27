# by holiday
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------
param(
    [String] $MkvToolNixPath,
    [String] $Resolution,
    [string] $InputVideo,
    [string] $InputAudio,
    [string] $InputEngSub,
    [string] $InputForcedSub,
    [string] $OutputVideo
)
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------
# dimension
if ($Resolution -eq '360p') {
    $dimension = '0:480×360'
} elseIf ($Resolution -eq '480p') {
    $dimension = '0:640×480'
} elseIf($Resolution -eq '720p'){
    $dimension = '0:1280x720'
} elseIf ($Resolution -eq '1080p') {
    $dimension = '0:1920x1080'
}
# video params
$videoParams1 = @('--language', '0:eng', '--default-track', '0:yes', '--forced-track', '0:no', '--display-dimensions')
$videoParams2 = @('--language', '1:eng', '--default-track', '1:no', '--forced-track', '1:no', '-a', '1', '-d', '0', '-S', '-T', '--no-global-tags', '--no-chapters')
# hungarian audio params
$hunAudioParams = @('--language', '0:hun', '--default-track', '0:yes', '--forced-track', '0:no', '-a', '0', '-D', '-S', '-T', '--no-global-tags', '--no-chapters')
# english subtitle params
$engSubParams = @('--language', '0:eng', '--default-track', '0:no', '--forced-track', '0:no', '-s', '0', '-D', '-A', '-T', '--no-global-tags', '--no-chapters')
# hungarian forced subtitle params
$forcedSubParams = @('--language', '0:hun', '--track-name', '0:forced', '--default-track', '0:yes', '--forced-track', '0:yes', '-s', '0', '-D', '-A', '-T', '--no-global-tags', '--no-chapters')
#-------------------------------------------------------------------------------------------------------------------------------------------------------------------
[string[]]$InputVideoFiles = $InputVideo.Replace("'","").Split(",")
[string[]]$InputAudioFiles = $InputAudio.Replace("'","").Split(",")
[string[]]$InputEngSubFiles = $InputEngSub.Replace("'","").Split(",")
[string[]]$InputForcedSubFiles = $InputForcedSub.Replace("'","").Split(",")
[string[]]$OutputVideoFiles = $OutputVideo.Replace("'","").Split(",")

for($i=0; $i -lt $InputVideoFiles.Length; $i++){
    if($InputForcedSubFiles[$i] -eq "null"){
        & $MkvToolNixPath -o $OutputVideoFiles[$i] $videoParams1 $dimension $videoParams2 $InputVideoFiles[$i] $hunAudioParams $InputAudioFiles[$i] $engSubParams $InputEngSubFiles[$i] --track-order "0:0,1:0,0:1,2:0"
    } else {
        & $MkvToolNixPath -o $OutputVideoFiles[$i] $videoParams1 $dimension $videoParams2 $InputVideoFiles[$i] $hunAudioParams $InputAudioFiles[$i] $engSubParams $InputEngSubFiles[$i] $forcedSubParams $InputForcedSubFiles[$i] --track-order "0:0,1:0,0:1,2:0,3:0"
    }
}

